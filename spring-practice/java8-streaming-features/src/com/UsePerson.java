package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Create a stream of Person objects and Execute some Queries
 * 
 * @author omalve
 *
 */
public class UsePerson {

	private List<Person> personList = null;
	private Scanner sc = null;
	private Comparator<Person> t = null;

	public UsePerson() {
		sc = new Scanner(System.in);
		personList = new ArrayList<Person>() {
			private static final long serialVersionUID = 1L;
			{
				add(new Person(1, "Pravin", 50, 45000.00, true));
				add(new Person(2, "Sameer", 60, 35000.00, true));
				add(new Person(3, "Pankaj", 40, 46000.00, true));
				add(new Person(4, "Prajwal", 35, 885000.00, true));
				add(new Person(5, "Prakash", 80, 22000.00, true));

				add(new Person(6, "Pramila", 29, 85000.00, false));
				add(new Person(7, "Prachi", 32, 69000.00, false));
				add(new Person(8, "Pooja", 59, 32000.00, false));
				add(new Person(9, "Priya", 79, 25000.00, false));
				add(new Person(10, "Pratiksha", 70, 111000.00, false));
				add(new Person(10, "Pratiksha", 70, 111000.00, false));
				add(new Person(10, "Pratiksha", 70, 111000.00, false));
			}
		};
	}

	public static void main(String[] args) {
		UsePerson up = new UsePerson();
		up.printQueries();
		up.addToSetUniquely();
		up.sortByGivenOption();

	}

	private void addToSetUniquely() {
		@SuppressWarnings("serial")
		Set<Person> personSet = new HashSet<Person>() {
			{
				addAll(personList);
			}
		};
		print("Added to Set as:");
		personSet.stream().forEach(System.out::println);

	}

	private void sortByGivenOption() {
		print("\t\t !!! Enter Option to sort !!!");
		boolean flag = false;
		while (!flag) {

			print("\n1. By Name->");
			print("2. By Weight->");
			print("3. By Salary->");
			print("4. Exit\n");
			int opt = sc.nextInt();

			switch (opt) {
			case 1:
				t = (p1, p2) -> {
					return p1.getName().compareTo(p2.getName());
				};
				sort(t);
				break;
			case 2:
				t = (p1, p2) -> {
					return Integer.signum((int) (p1.getWeight() - p2.getWeight()));
				};
				sort(t);
				break;
			case 3:
				t = (p1, p2) -> {
					return Integer.signum((int) (p1.getSalary() - p2.getSalary()));
				};
				sort(t);
				break;
			case 4:
				flag = true;
				break;
			default:
				print("Invalid Option!!!");
				break;
			}
		}
	}

	public void sort(Comparator<Person> t) {
		personList.stream().sorted(t).forEach(System.out::println);
	}

	public void printQueries() {
		Optional<Double> maxweightfromAll = personList.stream().map(temp -> temp.getWeight())
				.collect(Collectors.maxBy((a, b) -> Integer.signum((int) (a - b))));
		print("Max weight among all: " + maxweightfromAll.get());
		personList.stream().map(x -> x.getSalary()).max((x, y) -> Integer.signum((int) (x - y)));

		Optional<Double> maxweightfromFemale = personList.stream().filter(x -> !x.isGender())
				.map(temp -> temp.getWeight()).collect(Collectors.maxBy((a, b) -> Integer.signum((int) (a - b))));
		print("Max weight among Females: " + maxweightfromFemale.get());

		Optional<Double> minweightfromMale = personList.stream().filter(x -> x.isGender()).map(temp -> temp.getWeight())
				.collect(Collectors.minBy((a, b) -> Integer.signum((int) (a - b))));
		print("Min weight among Males: " + minweightfromMale.get());

		Double totalSalary = personList.stream().map(x -> x.getSalary())
				.collect(Collectors.summingDouble(x -> x.doubleValue()));
		print("Total Salary: " + totalSalary);

		Double averageSalary = personList.stream().map(x -> x.getSalary())
				.collect(Collectors.averagingDouble(x -> x.doubleValue()));
		print("Average Salary: " + averageSalary);

	}

	// print the message to console
	private void print(String message) {
		System.out.println(message);
	}
}
