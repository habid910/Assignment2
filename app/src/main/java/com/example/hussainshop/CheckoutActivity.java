package com.example.hussainshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent i = getIntent();
        String quantity = i.getExtras().getString("Quantity");
        TextView quantities = findViewById(R.id.textViewSubTotalAmount);
        quantities.setText(quantity);
    }
}
