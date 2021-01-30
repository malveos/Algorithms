package application;

import static Utility.Print.print;
import static Utility.Print.printline;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import handlers.BankHandler;
import handlers.UserHandler;

/**
 * This is main menu which gives option to the user
 * 
 * @author omalve
 *
 */
public class MainMenu {

	private Scanner sc = null;
	private BankHandler bankapplication;
	private UserHandler userhandler;

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		MainMenu mm = new MainMenu();
		mm.printMainMenu();
	}

	private void printMainMenu() throws ClassNotFoundException, IOException {
		bankapplication = new BankHandler();
		userhandler = new UserHandler();
		printline();
		print("\n\t\t !!! Welcome to Our Bank !!!");

		boolean exit = false;
		int opt = 0;
		while (!exit) {
			sc = new Scanner(System.in);
			print("\n1. Login->");
			print("2. CreateAccount->");
			print("3. Exit->\n");
			try {
				opt = sc.nextInt();
			} catch (InputMismatchException e) {
				print("Input is in invalid format " + e);
				continue;
			}
			switch (opt) {
			case 1:
				userhandler.existingAccount();
				break;
			case 2:
				bankapplication.createAccount();
				break;
			case 3:
				exit = true;
				break;
			default:
				print("Invalid Option!!!");
				break;
			}
		}

	}

}
