package com.Hospital.Hospital;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Payment {
    static int totalpayment = 0;
    static Scanner sc = new Scanner(System.in);

    static String[] payment() {
        System.out.println("Enter department name:");
        String department = sc.nextLine();

        System.out.println("Choose Payment Method:\n1. Card\n2. UPI\n3. Cash");
        int choice = sc.nextInt();

        System.out.println("Enter payment amount:");
        int amount = sc.nextInt();
        sc.nextLine(); // Clear buffer

        switch (choice) {
            case 1:
                System.out.println("Payment done via Card.");
                break;
            case 2:
                System.out.println("Payment done via UPI.");
                break;
            case 3:
                System.out.println("Payment done via Cash.");
                break;
            default:
                System.out.println("Invalid payment method.");
                return new String[]{"Invalid", "0"};
        }

        totalpayment += amount;
        saveToFile(department, amount);
        return new String[]{department, String.valueOf(amount)};
    }

    static void saveToFile(String department, int amount) {
        try (FileWriter writer = new FileWriter("paymentRecords.txt", true)) {
            writer.write("Department: " + department + ", Amount: " + amount + " rupees.\n");
        } catch (IOException e) {
            System.out.println("❌ Failed to write to file: " + e.getMessage());
        }
    }

    static int getpayment() {
        return totalpayment;
    }
}
