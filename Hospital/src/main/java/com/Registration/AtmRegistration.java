package com.Registration;

import java.io.*;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AtmRegistration extends BankAbstract {
	static String accountNum;
	static String password;
	static double balance;

	public AtmRegistration(String accountNum, String password, double balance) {
		AtmRegistration.accountNum = accountNum;
		AtmRegistration.password = password;
		AtmRegistration.balance = balance;
	}

	@Override
	public void printDatail(String accountNum, double balance) {
		System.out.println();
		System.out.println("-----------------------------------------------------");
		System.out.println("Your account number is: " + accountNum);
		System.out.println("Your account password is: " + password);
		System.out.println("Your account balance is: " + balance);
	}

	// ✅ Save new account (append)
	public static void saveToFile(String accNum, String pass, double bal) {
		try (FileWriter fw = new FileWriter("accounts.txt", true)) {
			fw.write(accNum + "," + pass + "," + bal + "\n");
		} catch (IOException e) {
			System.out.println("Error saving to file.");
		}
	}

	// ✅ Check if account already exists
	public static boolean isDuplicateAccount(String newAccountNum) {
		try {
			File file = new File("accounts.txt");
			if (!file.exists()) return false;

			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] parts = line.split(",");
				if (parts.length > 0 && parts[0].equals(newAccountNum)) {
					sc.close();
					return true;
				}
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("Error checking account.");
		}
		return false;
	}

	// ✅ Load account details
	public static boolean loadFromFile(String accNum, String pass) {
		try {
			File file = new File("accounts.txt");
			if (!file.exists()) return false;

			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] parts = line.split(",");
				if (parts.length == 3 && parts[0].equals(accNum) && parts[1].equals(pass)) {
					accountNum = parts[0];
					password = parts[1];
					balance = Double.parseDouble(parts[2]);
					sc.close();
					return true;
				}
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("Error loading account.");
		}
		return false;
	}

	// ✅ Update account balance
	public static void updateBalanceInFile(String accNum, double newBalance) {
		try {
			File inputFile = new File("accounts.txt");
			File tempFile = new File("temp_accounts.txt");

			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			String currentLine;
			while ((currentLine = reader.readLine()) != null) {
				String[] parts = currentLine.split(",");
				if (parts.length == 3 && parts[0].equals(accNum)) {
					writer.write(parts[0] + "," + parts[1] + "," + newBalance + "\n");
				} else {
					writer.write(currentLine + "\n");
				}
			}
			writer.close();
			reader.close();

			// Replace old file with new one
			if (!inputFile.delete() || !tempFile.renameTo(inputFile)) {
				System.out.println("Error updating file.");
			}
		} catch (IOException e) {
			System.out.println("Error updating balance.");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			while (true) {
				System.out.println("---------------------------------");
				System.out.println("*********** ATM System Menu ******************");
				System.out.println("\n1. Create new account\n2. Withdraw\n3. Deposit\n4. Exit\n");
				System.out.println("***********************************************");
				System.out.println("Enter your choice:");
				int choice = sc.nextInt();

				if (choice == 1) {
					sc.nextLine(); // consume newline
					System.out.println("Enter 12-digit account number:");
					String inputAcc = sc.nextLine();

					if (isDuplicateAccount(inputAcc)) {
						System.out.println("❌ Account already exists!");
						continue;
					}

					System.out.println("Enter 4-digit password:");
					String inputPass = sc.nextLine();
					System.out.println("Enter initial balance:");
					double inputBalance = sc.nextDouble();

					if (inputAcc.length() == 12 && inputPass.matches("\\d{4}")) {
						saveToFile(inputAcc, inputPass, inputBalance);
						AtmRegistration atm = new AtmRegistration(inputAcc, inputPass, inputBalance);
						atm.printDatail(inputAcc, inputBalance);
					} else {
						System.out.println("❌ Invalid account number or password format.");
					}

				} else if (choice == 2 || choice == 3) {
					sc.nextLine(); // consume newline
					System.out.println("Enter your account number:");
					String acc = sc.nextLine();
					System.out.println("Enter your 4-digit password:");
					String pass = sc.nextLine();

					if (loadFromFile(acc, pass)) {
						Checking check = new Checking(accountNum, password, balance);

						if (choice == 2) {
							System.out.println("Enter withdraw amount:");
							double amount = sc.nextDouble();
							check.withdraw(amount);
						} else {
							System.out.println("Enter deposit amount:");
							double amount = sc.nextDouble();
							check.deposit(amount);
						}

						balance = Checking.balance;
						updateBalanceInFile(accountNum, balance);
						check.printDatail();
					} else {
						System.out.println("❌ Invalid account number or password.");
					}
				} else if (choice == 4) {
					System.out.println("Exiting at - " +
						LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy - hh:mm:ss a")));
					break;
				} else {
					System.out.println("Invalid choice!");
				}
			}
		} catch (Exception e) {
			System.out.println("Something went wrong. Please check your input.");
		} finally {
			sc.close();
			System.out.println("Thank you for visiting...");
		}
	}
}
