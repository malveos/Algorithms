package handlers;

import static Utility.Print.print;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import application.Submenu;
import model.User;

/**
 * This class handles user , it manages user login, user creation and account no
 * and pin generation
 * 
 * @author omalve
 *
 */

public class UserHandler {

	private User user = null;
	private Scanner sc = new Scanner(System.in);
	private Properties prop = new Properties();
	private OutputStream input = null;
	private BankHandler bankhandler = null;
	private Submenu submenu = null;
	
	public UserHandler() throws ClassNotFoundException, IOException {
		
		submenu = new Submenu();
	}
	User getUser() {
		user = new User();
		Long accountNumber = requestAccountNumber();
		int accountPin = generatePin();
		String name = null;
		double bal = 0;
		try {
			print("Enter Your Name");
			name = sc.next();
			print("Enter Opennig Balance");
			bal = sc.nextDouble();
			while (bal < 500) {
				print("Balance cannot be less than 500, Enter Again:");
				bal = sc.nextDouble();
			}
		} catch (InputMismatchException e) {
			print("Invalid format of data .... Try Again " + e);
			return null;
		}
		user.setUserName(name);
		user.setBalance(bal);
		user.setAccountNumber((accountNumber));
		user.setAccountPin((accountPin));

		return user;
	}

	// Verification and Login
	public String login() throws IOException {
		String accountNo = "";
		Integer pin;
		sc = new Scanner(System.in);
		try {
			print("Enter Account Number:---");
			accountNo = sc.nextLong() + "";
			print("Enter Pin:---");
			pin = sc.nextInt();
			if (checkUserExists(accountNo, pin))
				print("Successfully Logged In.");
			else {
				print("Invalid credentials.");
				return null;
			}
		} catch (InputMismatchException e) {
			print("Input is in invalid format " + e);
			return -1 + "";
		}
		return accountNo;
	}

	//Check current User
		public void existingAccount() throws ClassNotFoundException, IOException {
			bankhandler=new BankHandler();
			User u = null;
			try {
				u = bankhandler.getCurrentUser();
			} catch (ClassNotFoundException | IOException e) {
				print("Error occured" + e);
			}
			if (u != null)
				submenu.displayOptions(u);

		}
	
	// Add credentials to properties file
	public void addToProperties(long accountNumber, int accountPin) {
		try {
			input = new FileOutputStream("src\\properties\\UserInfo.properties", true);
			// print(accountNumber+accountPin+"");
			prop.setProperty(accountNumber + "", accountPin + "");
			prop.store(input, null);
			input.close();

		} catch (IOException ex) {
			print("Exception occured!!! Try Again " + ex);
		}
	}

	// check user credentials from properties file
	private boolean checkUserExists(String accountN, Integer pin) throws IOException {
		prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src\\properties\\UserInfo.properties");

		prop.load(input);
		if (prop.getProperty(accountN) == null) {
			return false;
		}
		int savedPin = Integer.parseInt(prop.getProperty(accountN));
		if (savedPin != pin.intValue()) {
			return false;
		}
		return true;
	}

	// Generate Random 4 Digit Pin
	private int generatePin() {
		String id = String.format("%04d", new Random().nextInt(10000));
		return Integer.parseInt(id);
	}

	// Generate Random 8 Digit account number
	private long requestAccountNumber() {
		String id = String.format("%08d", new Random().nextInt(100000000));
		return Integer.parseInt(id);
	}
}
