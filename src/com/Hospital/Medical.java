package com.Hospital;

import java.util.Scanner;

public class Medical {
    public void medical(){
        System.out.println("**********************************");
        System.out.println("Welcome to the Medical of Hospital");
        System.out.println("***********************************");
        System.out.println("Near is the Medical instruction..");
        System.out.println("*************************************");
        System.out.println("***************************************");
        System.out.println("The information about medical\n - paracital goli - 5 to 10(per one)rupees\n - operation literature - 50 to 1500(per one) rupees\n - skin scream - 100 to 2000 (per one)rupees\n - Any organ bottle - 250 to 1400 (per one)rupees\n");
        System.out.println("**************************************");
        System.out.println("\n1.paracitamal goli.\n2.operation literature.\n3.skin scream\n4.organ medicine\n");
        System.out.println("**************************************");
        System.out.println("***************************************");
        System.out.println("choice the option:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Give the normal patient they are only head,low energy down. ");
                break;
            case 2:
                System.out.println("give the patient and doctor for use for operation like sessor.");
                break;
            case 3:
                System.out.println(" Any people for skin dray or any problem about skin then take skin scream");
                break;
            case 4:
                System.out.println("any about organ like stomach,eye drop,ear drop,etc to take it");
                break;

            default:System.out.println("Invalid choice");
        }
        System.out.println("***************************************");
        System.out.println("Any problem about medical talk to Doctor..");
        System.out.println("****************************************");
        System.out.println("Medical charges payed to the payment section");
        System.out.println("*****************************************");
    }
}
