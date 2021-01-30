package handlers;

import static Utility.Print.print;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import exception.MyException;
import model.User;
import storage.DataStore;

/**
 * This is bank handler ,it has facilities like login with credentials, money
 * withdraw, deposit, balance check, scheduling the balance It uses hashmap for
 * saving bank data and properties file for saving credentials.
 * 
 * @author omalve
 *
 */
@SuppressWarnings("unused")
public class BankHandler implements Serializable {

	private static final long serialVersionUID = 1L;
	private UserHandler userhandler;
	private Scanner sc;
	private BufferedReader br;
	private Properties prop = null;
	private OutputStream input = null;

	public BankHandler() throws ClassNotFoundException, IOException {
		sc = new Scanner(System.in);
		prop = new Properties();
		br = new BufferedReader(new InputStreamReader(System.in));
		userhandler = new UserHandler();
	}

	// Create account in Bank
	public void createAccount() {
		User user = userhandler.getUser();
		Long accountNumber = user.getAccountNumber();
		int accountPin = user.getAccountPin();
		userhandler.addToProperties(accountNumber, accountPin);
		print("Account is successfully created!!!");
		print("Remember-->\nYour accountNo\t:\t" + accountNumber + "\nPin\t\t:\t" + accountPin);
		try {
			DataStore.getInstance().save(user);
		} catch (IOException e) {
			print("Account creation failed, Try Again" + e);
		}
	}

	

	public void withdraw(User obj) {
		Runnable r1 = () -> {
			obj.getAccountNumber();
			print("Enter amount to withdraw:");
			int amount = 0;
			try {

				amount = Integer.parseInt(br.readLine());
				if (amount <= 0)
					throw new MyException("Amount must be greater than zero!!!");

				if (amount > obj.getBalance())
					print("Low Balance");
				else
					obj.setBalance(obj.getBalance() - amount);
				print("Your New Balance is:" + obj.getBalance());

				DataStore.getInstance().save(obj);
			} catch (NumberFormatException e) {
				print("Please, Enter only Digits");
				// e.printStackTrace();
			} catch (IOException | MyException e) {
				try {
					throw new MyException();
				} catch (MyException e1) {
					// e1.printStackTrace();
				}
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			print("Transaction interrupted:" + e);
		}
	}

	public void deposit(User obj) {
		Runnable r2 = () -> {
			print("Enter amount to deposit:");
			int amount = 0;
			try {
				amount = sc.nextInt();
				if (amount <= 0)
					throw new MyException("Amount should be Greater than 0");
				obj.setBalance(obj.getBalance() + amount);
				print("Your Balance is:" + obj.getBalance());
				DataStore.getInstance().save(obj);
			} catch (InputMismatchException e) {
				print("Invalid format for data " + e);
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
		Thread t = new Thread(r2);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			print("Transaction interrupted:" + e);
		}

	}

	public void getBalance(User obj) {
		Runnable r3 = () -> print("Your Balance is:" + obj.getBalance());
		Thread t3 = new Thread(r3);
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e) {
			print("Transaction interrupted:" + e);
		}
	}

	public User getCurrentUser() throws ClassNotFoundException, IOException {
		String accountNo = userhandler.login();
		if (accountNo == null || "-1".equals(accountNo)) {
			print("Login failed : ");
			return null;
		}
		// * Get User *//
		User u = DataStore.getInstance().retrieveUser(accountNo);
		return u;
	}

	public void schedule(User obj) {
		Runnable r4 = () -> print("Balance--" + obj.getBalance());
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(0);
		ses.scheduleWithFixedDelay(r4, 5, 15, TimeUnit.SECONDS);
	}

}
