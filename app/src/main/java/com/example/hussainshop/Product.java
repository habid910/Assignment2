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

}
