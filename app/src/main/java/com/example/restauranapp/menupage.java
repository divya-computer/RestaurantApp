package com.example.restauranapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class menupage extends AppCompatActivity
{
    RecyclerView mRecyclerView;
    FoodData mFoodData;
    List<FoodData> myFoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupage);

        mRecyclerView = (RecyclerView)findViewById(R.id.recycleview);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(menupage.this,1);
        mRecyclerView.setLayoutManager((gridLayoutManager));

        myFoodList = new ArrayList<>();

        mFoodData = new FoodData("Manchurian","Vegetable Manchurian is an Indo-Chinese food. It is an exotic dish made of mixed vegetable steamed formed into dumplings deep fried and cooked in a tangy sauce. ... Manchurian is normally eaten as an evening snack, appetizer accompanied with noodles. It is best when served hot","Rs.270",R.drawable.manchurian);
        myFoodList.add(mFoodData);
        mFoodData = new FoodData("Pizza","Pizza is a savory dish of Italian origin, consisting of a usually round, flattened base of leavened wheat-based dough topped with tomatoes, cheese, and often various other ingredients (anchovies, olives, meat, etc.)","Rs.330",R.drawable.pizza);
        myFoodList.add(mFoodData);
        mFoodData = new FoodData("Noodles","Noodles are a type of food made from unleavened dough which is rolled flat and cut, stretched or extruded, into long strips or strings. Noodles can be refrigerated for short-term storage or dried and stored for future use. Noodles are usually cooked in boiling water, sometimes with cooking oil or salt added.","Rs.180",R.drawable.noodles);
        myFoodList.add(mFoodData);
        mFoodData = new FoodData("Nachos","Nachos is a Tex-Mex dish from northern Mexico that consists of heated tortilla chips or totopos covered with melted cheese (or a cheese-based sauce), often served as a snack or appetizer.","Rs.450",R.drawable.nachos);
        myFoodList.add(mFoodData);
        mFoodData = new FoodData("Pasta","Pasta is a type of food made from a mixture of flour, eggs, and water that is formed into different shapes and then boiled. Spaghetti, macaroni, and noodles are types of pasta.","Rs.140",R.drawable.pasta);
        myFoodList.add(mFoodData);


        MyAdapter myAdapter = new MyAdapter(menupage.this,myFoodList);
        mRecyclerView.setAdapter(myAdapter);
    }
}
