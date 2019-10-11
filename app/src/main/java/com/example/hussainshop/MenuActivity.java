package com.example.hussainshop;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
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

public class MenuActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Product> products = new ArrayList<>();

    TextView quantityItems;
    Button mButtonAdd;
    FloatingActionButton fab;
    double cost;
    final ArrayList<String> selectedItems = new ArrayList();
    int checkedItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        initializeData();
        initializeAdapter();
        quantityItems = findViewById(R.id.textViewQuantitys);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Where we track the selected items

                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                // Set the dialog title

                builder.setTitle("Please Select one of the following methods:")
                        // Specify the list array, the items to be selected by default (null for none),
                        // and the listener through which to receive callbacks when items are selected
                        .setSingleChoiceItems(R.array.methods, checkedItem, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                if (selectedItems.contains("Express")) {
                                    cost = 50;
                                } else if (selectedItems.contains("Regular")) {
                                    cost = 10;
                                } else if (selectedItems.contains("No hurry")) {
                                    cost = 0;
                                }


                            }
                        }).setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MenuActivity.this, CheckoutActivity.class);
                        intent.putExtra("Quantity",quantityItems.getText().toString());
                        startActivity(intent);

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     dialog.cancel();
                    }
                });
                builder.create().show();
            }
        });//end of click listener
    }

    private void initializeData() {
        products = new ArrayList<>();

        products.add(new Product(getResources().getString(R.string.priceFriedChicken), "0", "0.00", R.drawable.ic_friedchicken));
        products.add(new Product("19.99", "0", "0.00", R.drawable.ic_generaltao));
        products.add(new Product("13.95", "0", "0.00", R.drawable.ic_chickennugget));
    }

    private void initializeAdapter() {
        ProductAdapter adapter = new ProductAdapter(products);
        recyclerView.setAdapter(adapter);
    }


}

