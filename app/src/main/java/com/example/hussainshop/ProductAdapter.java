

package com.example.hussainshop;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private ArrayList<Product> products;
    LayoutInflater mInflater;

    public static class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ProductAdapter adapter;
        TextView price;
        TextView subTotal;
        ImageView foodPhoto;
        TextView quantity;
        Button mButtonAdd;
        int qty;
        double total;
        Button mButtonSubtract;


        ProductViewHolder(View itemView, ProductAdapter adapter) {
            super(itemView);
            price = (TextView) itemView.findViewById(R.id.textViewPrice);
            subTotal = (TextView) itemView.findViewById(R.id.textViewSubTotalAmount);
            foodPhoto = (ImageView) itemView.findViewById(R.id.foodImage);
            quantity = itemView.findViewById(R.id.textViewQuantitys);
            mButtonAdd = itemView.findViewById(R.id.buttonAdd);
            mButtonAdd.setOnClickListener(this);
            mButtonSubtract = itemView.findViewById(R.id.buttonSubtract);
            mButtonSubtract.setOnClickListener(this);
            this.adapter = adapter;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonAdd:
                    ++qty;
                    quantity.setText(Integer.toString(qty));
                    total = Integer.parseInt(quantity.getText().toString()) * Double.parseDouble(price.getText().toString());
                    subTotal.setText(Double.toString(total));
                    getLayoutPosition();
                    break;
                case R.id.buttonSubtract:
                    if (Integer.parseInt(quantity.getText().toString()) == 0) {
                        quantity.setText("0");
                        Toast.makeText(v.getContext(), "Cannot Remove items.", Toast.LENGTH_SHORT).show();
                    } else
                        --qty;
                    quantity.setText(Integer.toString(qty));
                    total = Integer.parseInt(quantity.getText().toString()) * Double.parseDouble(price.getText().toString());
                    subTotal.setText(Double.toString(total));
                    break;


            }


        }
    }


    ProductAdapter(Context context, ArrayList<Product> products) {
        mInflater = LayoutInflater.from(context);
        this.products = products;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.cardlist_item, viewGroup, false);
        return new ProductViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder productViewHolder, int i) {
        productViewHolder.price.setText(products.get(i).price);
        productViewHolder.subTotal.setText(products.get(i).subtotal);
        productViewHolder.foodPhoto.setImageResource(products.get(i).photoId);
        productViewHolder.quantity.setText(products.get(i).getQuantity());

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
