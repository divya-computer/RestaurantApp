package com.example.restauranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity
{
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Transparent Action
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getSupportActionBar().hide();


        imageView = (ImageView)findViewById(R.id.hotelicon);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_anim);
        imageView.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation)
            {

            }

            @Override
            public void onAnimationEnd(Animation animation)
            {
                finish();
                startActivity(new Intent(SplashScreenActivity.this,MainActivity.class));
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }
        });
    }
}
