package com.kayky.model.entities;

public class Sale {

    public String name;
    public double price;
    public int quantity;
    public int quantityInStock;

    public Sale(){
    }

    public Sale(String name, double price, int quantity, int quantityInStock){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.quantityInStock = quantityInStock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void addItem(int quantity){
        this.quantity += quantity;
    }

    public void removeItem(int quantity){
        this.quantity -= quantity;
    }

    public void upgradeStock(){
        this.quantityInStock -= quantity;
    }

    public double total(){
        return quantity * price;
    }

    public String toString(){
        return name
                +String.format(", R$ %.2f, ", price)
                +"quantidade "
                +quantity
                +String.format( ", total R$%.2f", total())
                +", quantidade no estoque "
                +quantityInStock;
    }
}
