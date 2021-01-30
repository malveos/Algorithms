package com;

import javax.swing.*;

public class Print {

	public static void print(String message) {
		System.out.println(message);
	}

	public static void display(String message) {
		JOptionPane.showMessageDialog(null, message, "Message", 0);
	}
}
