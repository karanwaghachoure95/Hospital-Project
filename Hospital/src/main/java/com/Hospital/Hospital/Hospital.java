package com.Hospital.Hospital;

import java.util.*;

public class Hospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Waghachoure Hospital");

        System.out.print("Enter Email (Username): ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        login log = new login(user, pass);
        log.loginUser(sc);

        List<PaymentReceipt> allPayments = new ArrayList<>();

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Rest Room\n2. Operation\n3. Doctor\n4. Payment\n5. Medical\n6. Print Payment Receipts\n7. Exit");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    new RestRoom().Restroom();
                    break;
                case "2":
                    new Operation().operation();
                    break;
                case "3":
                    new Doctor().doctor();
                    break;
                case "4":
                    String[] payInfo = Payment.payment();
                    allPayments.add(new PaymentReceipt(payInfo[0], Integer.parseInt(payInfo[1])));
                    break;
                case "5":
                    new Medical().medical();
                    break;
                case "6":
                    for (PaymentReceipt p : allPayments) p.Receipt();
                    System.out.println("Total Payment: " + Payment.getpayment() + " rupees");
                    break;
                case "7":
                    System.out.println("Thank you! Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
