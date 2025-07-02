package com.Hospital;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RestRoom {
    public void Restroom() {
        System.out.println("***************************************");
        System.out.println("Welcome to Hospital Restroom");
        System.out.println("***************************************");
        System.out.println("****************************************");
        System.out.println("Near the instruction of restroom...");
        System.out.println("**************************************");
        System.out.println();
        System.out.println("***************************************");
        System.out.println("\n1.You will stay assay room,your charges is per day 100.\n2.You will stay normal room ,your charges is per day 50.\n3.You will no stay then you will not charges.\n4.You will exit\n ");
        System.out.println("****************************************");
        System.out.println("****************************************");
        System.out.println("You day stay limitation is 1 month");
        System.out.println("*****************************************");
        System.out.println("****************************************");
        System.out.println();
        System.out.println("*******************************************");
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("choice your following option:");
            int choice = sc.nextInt();
            System.out.println("*******************************************");
            System.out.println("*******************************************");
            System.out.println("How many day you will stay:");
            int day = sc.nextInt();
            System.out.println("********************************************");

            switch (choice) {
                case 1:
                    day = day * 100;
                    System.out.println("Your charges is: " + day);
                    break;
                case 2:
                    day = day * 50;
                    System.out.println("Your charges is: " + day);
                    break;
                case 3:
                    System.out.println("Your charges is Zero ");
                    break;
                case 4:
                    System.out.println("**************************************");
                    System.out.println("You will exit the restroom");
                    System.out.println("***************************************");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid day");
            }
            System.out.println("You will  booking the room ,your charges is " + day + "  you will be choice Payment option of department,and payment it.");
          }catch(InputMismatchException e){
             System.out.println("Please enter Integer input.");
        }
    }
}