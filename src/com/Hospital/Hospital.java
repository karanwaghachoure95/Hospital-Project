package com.Hospital;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Hospital {
    Hospital() {
        System.out.println("****************************************");
        System.out.println("Welcome our Website");
        System.out.println("***************************************");
    }

    public void Start(){
        System.out.println("You will start with Loging then after , you will see the all option about Hospital");
        System.out.println("*************************************************************************************************");
    }
    public static void main(String[] args) {
        Hospital h = new Hospital();
        h.Start();

        // Hospital Login Part
        List<PaymentReceipt> allPayments = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("***********************************************");
        System.out.println("You not know the hospital username and password then you will set the username and password NO-No and Reset our Username and password and Logging");
        System.out.println("***********************************************");
        System.out.println("Enter the Hospital username:");
        String Username = sc.nextLine();
        System.out.println("Enter the Hospital password:");
        String password = sc.nextLine();
        System.out.println("**************************************************************************************************");
        System.out.println("You will not Know hospital username or password then reset your username or password and logging");
        System.out.println("*************************************************************************************************");

        login l1 = new login(Username, password);
        System.out.println();
        System.out.println("Checking Username and Password...");
        System.out.println();
        l1.loginUser(sc);

        // Declare risit OUTSIDE the loop to keep the last payment info
        PaymentReceipt risit;
        // Department part
        while (true) {
            System.out.println();
            System.out.println("**********************************");
            System.out.println("Near is department information");
            System.out.println("***********************************");
            System.out.println();
            System.out.println("\n1.Apko rest room mein jana hai tho 1 dabayiye.\n2.Apako Operation room mein jana hai tho 2 dabayiye.\n3.Apako Doctor se milana hai tho 3 dabayiye.\n4.Apako Payment karna hai tho 4 dabayiye.\n5.Apako Medical jana hai tho 5 dabayiye\n6.Total payment Risit leni hai tho 6 dabayiye\n7.Apako exit hona hai tho 7 dabayiye.\n");
            System.out.println("Enter your choice:");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.println();
                    RestRoom R = new RestRoom();
                    R.Restroom();
                    break;

                case "2":
                    Operation op = new Operation();
                    op.operation();
                    break;

                case "3":
                    Doctor doc = new Doctor();
                    doc.doctor();
                    break;

                case "4":
                    String[] paymentInfo = Payment.payment();
                    String department = paymentInfo[0];
                    int pay = Integer.parseInt(paymentInfo[1]);
                     risit = new PaymentReceipt(department, pay);
                    allPayments.add(risit);  // ✅ List mein add karo
                    break;

                case "5":
                    Medical med = new Medical();
                    med.medical();
                    break;

                case "6":
                    if (!allPayments.isEmpty()) {
                        System.out.println("******** HOSPITAL PAYMENT RECEIPT ********");
                        for (PaymentReceipt r : allPayments) {
                            r.Receipt();
                        }
                        System.out.println("***********************************************************");
                        System.out.println("Total Hospital Payment: " + Payment.getpayment() + " rupees");
                        System.out.println("************************************************************");
                    } else {
                        System.out.println("Koi bhi payment nahi hua abhi tak.");
                    }
                    break;

                case "7":
                    System.out.println("********************************************");
                    System.out.println("System se bahar nikal rahe hain. Dhanyavaad!");
                    System.out.println("*******************************************");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
