package Utility;

import java.util.stream.Stream;

import javax.swing.*;
/**
 * This is utility class for printing in the format
 * @author omalve
 *
 */
public class Print {

	
	public static void print(String message) {
		System.out.println(message);
	}

	public static void display(String message) {
		JOptionPane.showMessageDialog(null, message );
	}
	public static void printline() {
		Stream.generate(()->" _").limit(30).forEach(System.out::print);
	}
}
