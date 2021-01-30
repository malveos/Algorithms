package com.MR.example;

@FunctionalInterface
interface staticM{
	void st();
}

interface instanceM{
	void it();
}

interface constructorM{
	void ct();
}

@FunctionalInterface
interface errorI{
	void play();
	
	//Default Method
	default String getName() {
		//Default method requires body;
		System.out.println("Hello");
		return "";
	}
	
	
	//These methods require no body 
	//Static method
	static void sorry() {
		System.out.println("Static method called");
	}
	
	String toString();
	int hashCode();
	boolean equals(Object o);
	
}

class useFunctional implements errorI {
	@Override
	public void play() {
		System.out.println("Play methd of another Class");
	}
}
