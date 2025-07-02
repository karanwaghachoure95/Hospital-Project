package com.Hospital;

import java.util.Scanner;

public class Doctor {
    public void doctor() {
        System.out.println("***************************************");
        System.out.println("Welcome to Hospital Doctor");
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println("Instruction of the Doctor is below");
        System.out.println("***************************************");
        System.out.println("***************************************");
        System.out.println("\n-Normal Doctor charged - 30 \n-heart Doctor charged - 150 \n-Delivery Doctor charged - 300\n");
        System.out.println("***************************************");
        System.out.println("\n1. 6 am to 10 am is normal doctor.\n2.10 am to 2 pm heart doctor.\n3.2 pm to 3 pm eating time. \n4.3pm to 6 pm Women Delivery Doctor.\n5.Exit the program.\n");
        System.out.println("***************************************");
            System.out.println("choice your following option:");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            System.out.println("*******************************************");
            switch (choice) {
                case 1:
                    System.out.println("check the Doctor to patient ");
                    break;
                case 2:System.out.println("check the Doctor to heart patient");
                    break;
                case 4:
                    System.out.println("check the Doctor to delivery patient");
                    break;
                case 5:
                    System.out.println("**************************************");
                    System.out.println("You will exit the program");
                    System.out.println("***************************************");
                    System.exit(0);
                    break;

                default:System.out.println("Invalid day");
            }
        System.out.println("Check the Doctor patient and Perform the say this Doctor task. ");
        System.out.println("Doctor chacking charged payed in payment section..");
    }
}