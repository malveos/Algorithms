package functionalInterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * This is a class which implements custom comparator for the Product class
 * 
 * @author omalve
 *
 */

public class ComparatorUsingLambda {

	public static void main(String[] args) {

		@SuppressWarnings("serial")
		List<Product> plist = new ArrayList<Product>() {
			{
				add(new Product("Fan", 10, 700.15));
				add(new Product("Cooler", 60, 1700.15));
				add(new Product("Mixer", 50, 300.15));
				add(new Product("Grinder", 10, 290.50));
				add(new Product("Oven", 100, 1200.25));
				add(new Product("Toaster", 410, 100.80));
			}
		};
		ComparatorUsingLambda obj = new ComparatorUsingLambda();
		obj.sortByName(plist);
		obj.sortByPrice(plist);
		obj.sortByCount(plist);
		obj.fiterByCount(plist);
	}

	// Filtering Products using Streams and lambda
	private void fiterByCount(List<Product> plist) {
		System.out.println("Filtered Data where count is greater than 40");
		Stream<Product> strProduct = plist.stream().filter(p -> p.getCount() > 40);
		strProduct.forEach(System.out::println);
		System.out.println("\n\n\n");
	}
	
	// Sort Products by Count
	private void sortByCount(List<Product> plist) {		
		Collections.sort(plist, (p1, p2) -> {
			return Integer.signum(p1.getCount() - p2.getCount());
		});
		System.out.println("Sorted By Count:");
		plist.forEach(p -> System.out.println(p));
		System.out.println("\n\n");
	}

	// Sort Products by Price
	private void sortByPrice(List<Product> plist) {		
		Collections.sort(plist, (p1, p2) -> {
			boolean b = p1.getPrice() > p2.getPrice();
			if (b == true)
				return 1;
			else
				return -1;
		});
		System.out.println("Sorted By Price:");
		plist.forEach(p -> System.out.println(p));
		System.out.println("\n\n");
	}

	// Using list , comparator
	// Sort Products by Name
	private void sortByName(List<Product> plist) {
		Collections.sort(plist, (p1, p2) -> {
			return p1.getName().compareTo(p2.getName());
		});
		System.out.println("Sorted By Name:");
		plist.forEach(System.out::println);
		System.out.println("\n\n");
	}
}
