package com.Hospital.Hospital;

import java.util.Scanner;

public class Doctor {
    public void doctor() {
        System.out.println("***************************************");
        System.out.println("Welcome to Hospital Doctor");
        System.out.println("***************************************");
        System.out.println("Charges:\n- Normal Doctor: ₹30\n- Heart Doctor: ₹150\n- Delivery Doctor: ₹300");
        System.out.println("\nTimings:");
        System.out.println("1. 6 AM to 10 AM - Normal Doctor");
        System.out.println("2. 10 AM to 2 PM - Heart Doctor");
        System.out.println("3. 2 PM to 3 PM - Lunch Time");
        System.out.println("4. 3 PM to 6 PM - Delivery Doctor");
        System.out.println("5. Exit");

        Scanner sc = new Scanner(System.in);
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> System.out.println("Checking Normal Patient...");
            case 2 -> System.out.println("Checking Heart Patient...");
            case 4 -> System.out.println("Checking Delivery Patient...");
            case 5 -> {
                System.out.println("Exiting Doctor section.");
                System.exit(0);
            }
            default -> System.out.println("Invalid option.");
        }

        System.out.println("Please proceed to payment section.");
    }
}
