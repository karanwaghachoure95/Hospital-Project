package com.Registration;

import java.util.Scanner;
public class Checking extends AtmRegistration {
    Scanner sc = new Scanner(System.in);
    static String accountNum;
    static  String password;
    static  double balance;

    protected Checking(String accountNum, String password, double balance) {
        super(accountNum, password, balance);
        Checking.accountNum = accountNum;
        Checking.password = password;
        Checking.balance = balance;
    }

    protected double withdraw(double amount) {

        if (Checking.accountNum.equals(accountNum) && Checking.password.equals(password)) {
            if (Checking.balance - amount < 500) {
                System.out.println("Your balance is not sufficient....");
            } else {
            	Checking.balance = Checking.balance - amount;
                System.out.println("Withdrawal successful.");
                System.out.println("-------------------------------------");
                return Checking.balance;
            }
        } else {
            System.out.println("Your input is wrong, please check...");
            System.out.println("-------------------------------------");
        }
        return Checking.balance;
    }
    
    protected double deposit(double money) {
    	Checking.balance=Checking.balance+money;
    	return Checking.balance;
    }

   
    public void printDatail() {
        System.out.println("Your account number is: " + Checking.accountNum);
        System.out.println("Your account available balance is: " + Checking.balance);
    }
}

