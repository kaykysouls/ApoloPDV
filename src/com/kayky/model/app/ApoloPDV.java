package com.kayky.model.app;

import com.kayky.model.entities.Sale;

import java.util.Locale;
import java.util.Scanner;

public class ApoloPDV {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        System.out.print("Nome: ");
        String name = input.nextLine();
        System.out.print("Preco: R$ ");
        double price = input.nextDouble();
        System.out.print("Quantidade a ser adquirida: ");
        int quantity = input.nextInt();

        int quantityInStock = 100;

        Sale sale = new Sale(name, price, quantity, quantityInStock);

        sale.upgradeStock();

        System.out.println("Venda atual: " + sale);

        System.out.println();

        System.out.print("Quantos itens quer adicionar a venda? ");
        quantity = input.nextInt();

        sale.addItem(quantity);
        sale.upgradeStock();
        System.out.println("Venda atualizada: " + sale);

        System.out.println("Quantos itens deseja remover da venda? ");
        quantity = input.nextInt();
        sale.removeItem(quantity);
        sale.upgradeStock();

        System.out.println("Venda atualizada: " + sale);

        input.close();
    }
}
