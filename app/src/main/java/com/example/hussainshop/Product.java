package com.example.hussainshop;

import java.util.ArrayList;
import java.util.List;

public class Product {
    String price;
    String quantity;
   String subtotal;
    int photoId;
    private List<Product> products;
      public Product(String price,String quantity,String subtotal,int photoId){
        this.price=price;
        this.quantity=quantity;
        this.subtotal=subtotal;
        this.photoId=photoId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
