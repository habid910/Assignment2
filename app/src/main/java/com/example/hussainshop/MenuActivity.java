package com.example.hussainshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity  {
 RecyclerView recyclerView;
    List<Product> products = new ArrayList<>();
    int quantity;
    TextView quantityItems;
    Button mButtonAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
       recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        initializeData();
        initializeAdapter();
        quantityItems = findViewById(R.id.textViewQuantitys);




    }
    private void initializeData(){
        products = new ArrayList<>();
        products.add(new Product("12.99","0","0.00",R.drawable.ic_friedchicken));
        products.add(new Product("19.99","0","0.00",R.drawable.ic_generaltao));
        products.add(new Product("13.95","0","0.00",R.drawable.ic_chickennugget));
    }
    private void initializeAdapter(){
        ProductAdapter adapter = new ProductAdapter(products);
        recyclerView.setAdapter(adapter);
    }



}

