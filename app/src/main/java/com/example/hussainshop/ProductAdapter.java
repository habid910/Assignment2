package com.example.hussainshop;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView price;
        TextView subTotal;
        ImageView foodPhoto;
        TextView quantity;



        ProductViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cardview);
            price = (TextView)itemView.findViewById(R.id.textViewPrice);
            subTotal = (TextView)itemView.findViewById(R.id.textViewSubTotalAmount);
            foodPhoto = (ImageView)itemView.findViewById(R.id.foodImage);
            quantity = itemView.findViewById(R.id.textViewQuantitys);
        }
    }

   List<Product> products;

    ProductAdapter(List<Product> products){
        this.products=products;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardlist_item, viewGroup, false);
        ProductViewHolder pvh = new ProductViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder productViewHolder, int i) {
        productViewHolder.price.setText(products.get(i).price);
        productViewHolder.subTotal.setText( products.get(i).subtotal);
        productViewHolder.foodPhoto.setImageResource(products.get(i).photoId);
        productViewHolder.quantity.setText( products.get(i).quantity);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}