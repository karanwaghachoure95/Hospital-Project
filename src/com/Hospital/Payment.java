package com.Hospital;

import java.util.Scanner;

public class Payment {
    static int totalpayment = 0;
    static Scanner sc = new Scanner(System.in);

    static String[] payment() {
        System.out.println("***************************************");
        System.out.println("Welcome to Hospital Payment");
        System.out.println("***************************************");
        System.out.println("********************************************");
        System.out.println("Near the instruction about pay the Payment.");
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("How to you payment,choice the near the option.");
        System.out.println("********************************************");
        System.out.println("\n1.You will be pay card\n2.you will pay google pay,phone pay\n3.You will Payment cash\n4.You will be Exit..\n");
        System.out.println("***************************************************");

        System.out.println("Which department you will payed: ");
        String department = sc.nextLine();

        int choice ;
        int pay ;

        try {
            System.out.println("choice your following option:");
            choice = sc.nextInt();
            System.out.println("*******************************************");
            System.out.println("How many Payment you will be payed:");
            pay = sc.nextInt();
            sc.nextLine();  // Consume newline left-over
        } catch (Exception e) {
            System.out.println("❌ Invalid input! Please enter numbers only.");
            sc.nextLine(); // clear the invalid input
            return new String[]{"Invalid", "0"};
        }

        System.out.println("********************************************");
        switch (choice) {
            case 1:
                System.out.println("Payment is payed card, the payment is : " + pay);
                break;
            case 2:
                System.out.println("Payment is payed online , the payment is : " + pay);
                break;
            case 3:
                System.out.println("Payment is payed cash, the payment is : " + pay);
                break;
            case 4:
                System.out.println("**************************************");
                System.out.println("You will exit the Payment system");
                System.out.println("***************************************");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
        }

        System.out.println("You will payed the payment " + pay + " You will choice the option this option suitable for you.");
        totalpayment += pay;

        return new String[]{department, String.valueOf(pay)};
    }

    static public int getpayment() {
        return totalpayment;
    }
}
