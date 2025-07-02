package com.Hospital.Hospital;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RestRoom {
    public void Restroom() {
        System.out.println("***************************************");
        System.out.println("Welcome to the Rest Room");
        System.out.println("***************************************");
        System.out.println("Room Options:");
        System.out.println("1. Assay Room - ₹100/day");
        System.out.println("2. Normal Room - ₹50/day");
        System.out.println("3. No stay");
        System.out.println("4. Exit");

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            System.out.print("How many days will you stay? ");
            int days = sc.nextInt();
            int charge = 0;

            switch (choice) {
                case 1 -> charge = days * 100;
                case 2 -> charge = days * 50;
                case 3 -> {
                    System.out.println("No stay chosen. No charges.");
                    return;
                }
                case 4 -> {
                    System.out.println("Exiting Restroom section.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option.");
            }

            System.out.println("Your total rest room charge is: ₹" + charge);
            System.out.println("Proceed to payment.");
        } catch (InputMismatchException e) {
            System.out.println("❌ Invalid input. Please enter valid integers.");
        }
    }
}
