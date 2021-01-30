package com;

public class Customer {

	private int id;
	private String name;
	private double income;

	public Customer(int id, String name, double income) {
		this.id = id;
		this.name = name;
		this.income = income;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getIncome() {
		return income;
	}

	public int getIncome1() {
		return (int) income;
	}

	@Override
	public String toString() {
		return new StringBuilder("Customer [id=" + id + ", name=" + name + ", income=" + income + "]").toString();
	}

}