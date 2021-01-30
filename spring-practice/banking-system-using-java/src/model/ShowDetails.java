package model;

import java.io.Serializable;


import static Utility.Print.print;

public class ShowDetails implements Runnable, Serializable{	
	private static final long serialVersionUID = 1L;
	private User b;
	
	public ShowDetails(User b) {
		this.b = b;
	}
	@Override
	public void run(){
		print("Name:\t\t"+b.getUserName());
		print("Account Number:\t"+b.getAccountNumber());
		print("Balance:\t"+b.getBalance());
	}

}
