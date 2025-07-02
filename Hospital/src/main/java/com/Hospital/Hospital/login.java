package com.Hospital.Hospital;

import java.util.Random;
import java.util.Scanner;

public class login {
    String username;
    String password;
    boolean available;

    public login(String username, String password) {
        this.username = username;
        this.password = password;
        this.available = true;
    }

    public void loginUser(Scanner sc) {
        boolean success = OTPGenerater(this.username, this.password, sc);
        printLine();
        if (success) {
            System.out.println("Your login is successfully completed");
            printLine();
            System.out.println();
            printLine();
            System.out.println();
            System.out.println("Welcome to Waghachoure Hospital....");
            System.out.println();
            printLine();
        } else {
            System.out.println("Your login is canceled");
        }
    }

    public boolean OTPGenerater(String username, String password, Scanner sc) {
        if (isCorrectCredentials(username, password)) {
            printCredentialsValidMsg();
            String otpcode = generateAndSendOTP();

            try {
                String code = getValidInput("Enter your OTP code:", sc);
                return setOtp(code, otpcode, sc);
            } catch (Exception e) {
                System.out.println("❌ Invalid OTP input.");
                return false;
            }

        } else {
            return ResetUsernamePassword(sc);
        }
    }

    public boolean ResetUsernamePassword(Scanner sc) {
        try {
            System.out.println("***************************");
            System.out.println("Reset the username and password");
            System.out.println("*******************************");

            String user = getValidInput("Reset hospital username and write your username:", sc);
            String pass = getValidInput("Reset hospital password and write your password:", sc);

            String username = getValidInput("Write your username:", sc);
            String password = getValidInput("Write your password:", sc);

            if (username.equals(user) && password.equals(pass)) {
                printCredentialsValidMsg();
                String otpcode = generateAndSendOTP();
                String code = getValidInput("Enter your OTP code:", sc);
                return setOtp(code, otpcode, sc);
            } else {
                System.out.println("Incorrect reset credentials.");
                return false;
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid input during reset.");
            return false;
        }
    }

    public boolean setOtp(String OTP, String otpcode, Scanner sc) {
        try {
            while (!OTP.equals(otpcode)) {
                OTP = getValidInput("Please enter the correct OTP code:", sc);
            }
            System.out.println("OTP Verification successful....");
            return true;
        } catch (Exception e) {
            System.out.println("❌ OTP input error.");
            return false;
        }
    }

    private String getValidInput(String prompt, Scanner sc) {
        String input;
        while (true) {
            System.out.println(prompt);
            input = sc.nextLine().trim();
            if (input.length() >= 4 && input.length() <= 25) {
                return input;
            } else {
                System.out.println("❌ Invalid input! Must be between 4 to 25 characters.");
            }
        }
    }

    private boolean isCorrectCredentials(String username, String password) {
        return username.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") && password.equals("karan@2004");
    }

    private String generateAndSendOTP() {
        printLine();
        System.out.println("Generating OTP and sending to your email: " + this.username);
        printLine();
        String otpcode = String.valueOf(new Random().nextInt(9000) + 1000); // 4 digit OTP
        printLine();
        System.out.println("OTP sent to your email. Please check and enter it below.");
        printLine();
        return otpcode;
    }

    private void printCredentialsValidMsg() {
        printLine();
        System.out.println("Your username and password are correct");
        printLine();
    }

    private void printLine() {
        System.out.println("*********************************");
    }
}
