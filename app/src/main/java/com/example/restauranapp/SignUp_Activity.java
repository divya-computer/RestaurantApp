package com.example.restauranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class SignUp_Activity extends AppCompatActivity
{
    EditText etuname,etphone,etemail,etpassword;
    Button register;
    AwesomeValidation awesomeValidation;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().setTitle("Sign In");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Assign Variable of EditText
        etuname    = findViewById(R.id.uname);
        etphone    = findViewById(R.id.mobilenumber);
        etemail    = findViewById(R.id.email);
        etpassword = findViewById(R.id.password);
        register   = findViewById(R.id.button);

        //Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //Add Validation For Name
        awesomeValidation.addValidation(this,R.id.uname, RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        //For Mobile Number
        awesomeValidation.addValidation(this,R.id.mobilenumber,"[5-9]{1}[0-9]{9}",R.string.invalid_mobile);
        //For Email
        awesomeValidation.addValidation(this,R.id.email, Patterns.EMAIL_ADDRESS,R.string.invalid_email);
        //For Password
        awesomeValidation.addValidation(this,R.id.password, ".{6,}",R.string.invalid_password);






        db = new DatabaseHelper(this);


        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String user = etuname.getText().toString().trim();
                String pwd  = etpassword.getText().toString().trim();

                //Check Validation
                if (awesomeValidation.validate())
                {
                    long val = db.addUser(user,pwd);


                    if (val > 0)
                    {
                        //On Success
                        Toast.makeText(SignUp_Activity.this, "Perfect Now Login", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignUp_Activity.this,SignIn_Activity.class);
                        startActivity(intent);
                    }
                    
                    else 
                    {
                        Toast.makeText(SignUp_Activity.this, "Registration ERROR", Toast.LENGTH_SHORT).show();
                    }

                   
                }
            }
        });



    }

    //This is Used when you click on Back you will go on previous activty rather then App exit
    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
