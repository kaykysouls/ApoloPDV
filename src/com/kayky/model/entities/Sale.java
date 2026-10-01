package com.kayky.model.entities;

import com.kayky.model.entities.enums.PaymentStatus;

import java.util.ArrayList;
import java.util.List;

public class Sale { //Classe responsavel pelo fechamento do carrinho, ato da venda em si

    public Double total;
    PaymentStatus statusPayment;

    List<Cart> sold = new ArrayList<>();

    public Sale(Double total, PaymentStatus statusPayment) {
        this.total = total;
        this.statusPayment = statusPayment;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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
        for(Cart itens: sold){
            total += itens.getSubtotal(itens.getProduct().getId());
        }
        return total;
    }

    @Override
    public String toString(){
        String NFC = "NOTA FISCAL: ";
        for(Cart itens: sold){
            NFC += "ID " + itens.getProduct().getId()+
                    ", "+ itens.getProduct().getName()+
                    ", quantidade " + itens.getQuantity()+
                    ", quantidade no estoque " + itens.getProduct().getQuantityInStock()+
                    String.format(", subtotal R$ %.2f, ",itens.getSubtotal(itens.getProduct().getId()))+
                    String.format("total R$ %.2f", checkout());
        }
        return NFC;
    }
}