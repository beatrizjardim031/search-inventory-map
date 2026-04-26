package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Program {
    static HashMap<String, Product> inventory = new HashMap<>();

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        loadInventory();
        System.out.print("What product are you looking for? " );
        String userChoice = input.nextLine();

        Product found = inventory.get(userChoice);
        if (found != null) {
            System.out.printf("id: %d %s | Price: $%.2f%n", found.getId(), found.getName(), found.getPrice());
        } else {
            System.out.println("Sorry, we don't have this product :(");
        }


    }
    public static void loadInventory() {

        System.out.print("What inventory would you like to see? ");
        String userChoice = input.nextLine();

        try {
            FileReader fileReader = new FileReader(userChoice);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while(line != null) {
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);


                inventory.put(name, new Product(id, name, price));
                line = bufferedReader.readLine();


            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Something went wrong... File could not be loaded.");
        }



    }
}



