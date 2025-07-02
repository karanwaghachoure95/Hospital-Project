package com.Hospital;

import java.util.Scanner;

public class Operation {
    public void operation() {
        System.out.println("***************************************");
        System.out.println("Welcome to Hospital Operation");
        System.out.println("***************************************");

        System.out.println("***************************************");
        System.out.println("Instruction of the Operation is below");
        System.out.println("***************************************");
        System.out.println("\n-Heart operation fee - 10000 rupees \n-delivery (normal) rupees - 5000 rupees \n-delivery (ciser) - 12000 rupees \n-eye operation - 30000 rupees \n-ear operation - 50000 rupees \n-knee operation - 40000 rupees\n");
        System.out.println("***************************************");
        System.out.println("\n1. 7 am to 11 pm Heart operation .\n2. 2 am to 4 am delivery operation.\n3. 5 am to 12 am normal operation(eye,ear,knee,etc) .\n4.Exit the program.\n");
        System.out.println("***************************************");
        System.out.println();
        System.out.println("choice your following option:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        System.out.println("*******************************************");
        switch (choice) {
            case 1:
                System.out.println("Perform the heart operation and result will say after the operation.");
                break;
            case 2:System.out.println("Perform the  delivery and result will say after the operation.");
                break;
            case 3:
                System.out.println("Perform the normal operation and result will say after the operation.");
                break;
            case 4:
                System.out.println("**************************************");
                System.out.println("You will exit the Operation program");
                System.out.println("***************************************");
                System.exit(0);
                break;

            default:System.out.println("Invalid day");
        }
        System.out.println("Doctor will Perform the operation and result will say after the operation. ");
        System.out.println("Operation fee will payed to the payment section");
        System.out.println("Any Problem to contact 1203-459-544-4343 number");

    }
}