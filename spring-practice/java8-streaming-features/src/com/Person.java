package com;

/**
 * This is Model class person with id, name, weight, salary, gender as attributes
 * 
 * @author omalve
 *
 */

public class Person {

	private int id;
	private String name;
	private double weight;
	private double salary;
	// true = male , false = female
	private boolean gender;

	public Person(int id, String name, double weight, double salary, boolean gender) {
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.salary = salary;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public double getSalary() {
		return salary;
	}

	public boolean isGender() {
		return gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (gender ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (gender != other.gender)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb
				.append("Person [id=" + id + ", name=" + name + ", weight=" + weight + ", salary=" + salary + ";" + "]")
				.toString();
	}

}
