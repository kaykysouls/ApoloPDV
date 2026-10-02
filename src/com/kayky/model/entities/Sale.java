package com.kayky.model.entities;

import com.kayky.model.entities.enums.PaymentStatus;

import java.util.ArrayList;
import java.util.List;

public class Sale { //Classe responsavel pelo fechamento do carrinho, ato da venda em si

    PaymentStatus statusPayment;

    List<Cart> sold = new ArrayList<>();

    public Sale(PaymentStatus statusPayment) {
        this.statusPayment = statusPayment;
    }

    public PaymentStatus getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(PaymentStatus statusPayment) {
        this.statusPayment = statusPayment;
    }

    public void addItem(Cart item){
        sold.add(item);
    }

    public void removeItem(Cart item){
        sold.remove(item);
    }

    public double checkout(){
        double total = 0;
        for(Cart itens: sold){
            total += itens.getSubtotal();
        }
        return total;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(Cart itens: sold){
            sb.append("ID: ").append(itens.getProduct().getId()).append("\n");
            sb.append(itens.getProduct().getName()).append("\n");
            sb.append(String.format("Preco R$ %.2f\n", itens.getProduct().getPrice()));
            sb.append("Quantidade ").append(itens.quantity).append("\n");
            sb.append("Quantidade no estoque ").append(itens.getProduct().getQuantityInStock()).append("\n");
        }
        sb.append(String.format("Total R$ %.2f\n", checkout()));
        return sb.toString();
    }
}