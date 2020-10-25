package com.example.restauranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailAboutFood extends AppCompatActivity
{
    TextView foodDescription;
    ImageView foodImage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_about_food);

        foodDescription = (TextView)findViewById(R.id.txtDescription);
        foodImage = (ImageView)findViewById(R.id.ivImage2);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null)
        {
            foodDescription.setText(mBundle.getString("Description"));
            foodImage.setImageResource(mBundle.getInt("Image"));
        }
    }
}
