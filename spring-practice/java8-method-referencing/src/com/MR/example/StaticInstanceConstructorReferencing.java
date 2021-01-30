package com.MR.example;

/**
 * @author omalve *
 * 
 *         This class demonstrate the different scenario for using method
 *         referencing
 */

public class StaticInstanceConstructorReferencing {

	public StaticInstanceConstructorReferencing() {

		System.out.println("Constructor Called");
	}

	public static void staticRefer() {

		System.out.println("Static method by method referencing");
	}

	public void instanceRefer() {
		System.out.println("Instance method by method referencing");
	}

	public static void main(String[] args) {

		// interface Method referenced to static method of class
		staticM sm = StaticInstanceConstructorReferencing::staticRefer;
		sm.st();

		// interface Method referenced to instance method of class
		// Here constructor also called due to instance method
		instanceM im = new StaticInstanceConstructorReferencing()::instanceRefer;
		im.it();

		// interface Method referenced to constructor of class
		constructorM cm = StaticInstanceConstructorReferencing::new;
		cm.ct();

		useFunctional m = new useFunctional();
		errorI ie = m::play;
		ie.play();
		ie.getName(); 	// Calling Default method
		errorI.sorry(); // Calling static method
	}

}
