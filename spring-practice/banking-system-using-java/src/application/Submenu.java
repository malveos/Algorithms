package application;

import static Utility.Print.print;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import handlers.BankHandler;
import model.ShowDetails;
import model.User;

/**
 * This is submenu which provides the menu for the user who have successfully
 * logged in.
 * 
 * @author omalve
 *
 */
public class Submenu {

	private Scanner sc = null;
	private BankHandler bankhandler;

	public Submenu() {
		sc = new Scanner(System.in);
	}

	// Display options for the user
	public void displayOptions(User obj) throws ClassNotFoundException, IOException {
		bankhandler = new BankHandler();
		print("\t\t!!! Hello " + obj.getUserName() + " !!!");
		boolean exit = false;
		int opt = 0;
		while (!exit) {
			sc = new Scanner(System.in);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			print("\n1.Show Details->");
			print("2.WithDraw Amount->");
			print("3.Deposit Amount->");
			print("4.Balance check->");
			print("5.Schedule Balancecheck In each 15 seconds");
			print("6.Exit->\n");
			try {
				opt = sc.nextInt();
			} catch (InputMismatchException e) {
				print("Input is in invalid format " + e);
			}
			switch (opt) {
			// Show Details
			case 1:
				Thread t = new Thread(new ShowDetails(obj));
				t.start();
				break;
			// Withdraw
			case 2:
				bankhandler.withdraw(obj);
				break;
			// Deposit
			case 3:
				bankhandler.deposit(obj);
				break;
			// Check Balance
			case 4:
				bankhandler.getBalance(obj);
				break;
			// Scheduling Check Balance
			case 5:
				bankhandler.schedule(obj);
				break;
			case 6:
				exit = true;
				break;
			default:
				print("Invalid Option!!!");
				break;
			}
		}

	}

	
}
