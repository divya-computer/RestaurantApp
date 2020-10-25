package com.example.restauranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Transparent Action
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getSupportActionBar().hide();

        login    = findViewById(R.id.btnlogin);
        register = findViewById(R.id.btnregister);

        //When click you will go on Signin Activity
        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "Login has been Clicked", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this , SignIn_Activity.class);
                startActivity(intent);
            }
        });

        //When click you will go on Signup Activity
        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "Register has been Clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this , SignUp_Activity.class);
                startActivity(intent);
            }
        });
    }
}
