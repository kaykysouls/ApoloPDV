package com.kayky.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart { //Carrinho de compras com os produtos a serem adquiridos

    Product product;
    Integer quantity;

    List<Product> itens = new ArrayList<>();

    public Cart(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal(int id){ //Calcula um grupo especifico de itens
        double subtotal = 0;
        if(product.getId() == id){
           subtotal += getProduct().getPrice() * quantity;
        }
        return subtotal;
    }
}
