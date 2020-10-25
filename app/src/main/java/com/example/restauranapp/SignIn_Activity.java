package com.example.restauranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn_Activity extends AppCompatActivity
{
    EditText loginuname,loginpassword;
    Button signin;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().setTitle("Login");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





    }

    // The validation is onclick on Login button so that i will check and allow to open the next activity.
    public void validation(View view)
    {
        loginuname    = findViewById(R.id.loginuname);
        loginpassword = findViewById(R.id.loginpassword);
        signin        = findViewById(R.id.button);

        db = new DatabaseHelper(this);

        String id = loginuname.getText().toString().trim();
        String password = loginpassword.getText().toString().trim();

        Boolean res = db.checkUser(id, password);

        if (res == true)
        {
            Toast.makeText(this, "SuccessFully Logged In ", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(SignIn_Activity.this,menupage.class);
            startActivity(intent1);
        }
        else
        {
            Toast.makeText(this, "Login Error", Toast.LENGTH_SHORT).show();
        }



//        if (id.equals("Divya") && password.equals("Shaparia"))
//        {
//            Toast.makeText(this, "You have Logged in Successfully...", Toast.LENGTH_LONG).show();
//
//            Intent intenta = new Intent(SignIn_Activity.this , menupage.class);
//            startActivity(intenta);
//        }
//        else
//        {
//            Toast.makeText(this, "Invalid Id or Password...", Toast.LENGTH_LONG).show();
//        }
    }

    //This is Used when you click on Back you will go on previous activty rather then App exit
    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}