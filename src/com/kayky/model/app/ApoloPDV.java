package com.kayky.model.app;

import com.kayky.model.entities.Cart;
import com.kayky.model.entities.Product;
import com.kayky.model.entities.Sale;
import com.kayky.model.entities.enums.PaymentStatus;

import java.util.Locale;
import java.util.Scanner;


public class ApoloPDV {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.println("Cadastro produto:");
        System.out.print("Quantos produtos serao cadastrados: ");
        int quantityInStock = input.nextInt();
        Sale sale = null;
        System.out.print("Quantos produtos deste produto deseja adquirir: ");
        int quantity = input.nextInt();

        for(int i=0;i<quantity;i++){
            System.out.print("ID: ");
            int id = input.nextInt();

            System.out.print("Nome: ");
            input.nextLine();
            String name = input.nextLine();

            System.out.print("Price: ");
            double price = input.nextDouble();

            String status = input.nextLine();

            Cart cart = new Cart(new Product(id, name, price, quantityInStock), quantity);
            sale = new Sale(cart.getSubtotal(cart.getProduct().getId()), PaymentStatus.PAYD);
            sale.addItem(cart);

        }
        System.out.println(sale);
        input.close();
    }
}
