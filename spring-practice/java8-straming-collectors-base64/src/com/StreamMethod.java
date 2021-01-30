package com;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * @author omalve This class implements the methods provided for the stream API
 *
 */

public class StreamMethod {

	// print message
	public static void print(String s) {
		System.out.println(s);
	}

	@SuppressWarnings("serial")
	public static void main(String[] a) {

		List<Customer> lcust = new ArrayList<Customer>() {
			{
				add(new Customer(1, "Vikrant", 100.00));
				add(new Customer(2, "Vicky", 200.00));
				add(new Customer(3, "Ravi", 300.00));
				add(new Customer(4, "Prashi", 400.00));
				add(new Customer(5, "Chikoo", 500.00));
				add(new Customer(6, "Mac", 600.00));
			}
		};

		// forEach, filter, map
		streamDemoBasic(lcust);

		//toList,  reduce, averagingDouble, maxBy, toMap
		streamDemoCollectors(lcust);		
		
		// method referencing, group by, partition by, summarizingDouble(statistical)
		streamDemoAdvanced(lcust);

		// time difference for stream and parallel stream operation
		//streamDemoComparision();
		
		// Encoding and decoding using base64 package
		java8Base64Cryptography();
	}

	public static void streamDemoComparision() {
		IntStream is  = IntStream.range(1, 1000000000);
		IntStream is2 = IntStream.range(1, 1000000000);
		
		LocalTime tstr1 = LocalTime.now();
		is.forEach(str->System.out.print(""));
		LocalTime tstr2 = LocalTime.now();
		Long diff = tstr1.until(tstr2,ChronoUnit.SECONDS );
	
		print("Parallel Stream:");
		is2.parallel().forEach(parstr->System.out.print(""));
		LocalTime tstr3 = LocalTime.now();
		Long diff2 = tstr2.until(tstr3,ChronoUnit.SECONDS );
		
		//output will be  84 and 162 seconds
		print("Time1 :" +diff+" Time2 : "+diff2);
	}

	public static void java8Base64Cryptography() {
		Encoder en = Base64.getEncoder();
		Decoder dn = Base64.getDecoder();

		print("\nEncoding and Decoding:");
		String secrete = " This is a private messsage";
		byte[] b = en.encode(secrete.getBytes());
		System.out.println(b.toString());

		String revealed = new String(dn.decode(b));
		System.out.println("Final DEcoding :" + revealed);
	}

	public static void streamDemoAdvanced(List<Customer> lcust) {
		print("\nMethod Referencing:");
		lcust.stream().map(Customer::getName).forEach(System.out::println);// method referencing two times

		print("\n\nGroup By count");
		// Grouping by
		lcust.stream().collect(Collectors.groupingBy(Customer::getName, Collectors.counting()))
				.forEach((name, count) -> System.out.println("Name:" + name + "  Count:" + count));

		print("\n\nPartition by income threshold");
		// Partitioning with income < 300
		lcust.stream().collect(Collectors.partitioningBy(p -> p.getIncome() < 300))
				.forEach((bool, list) -> System.out.println("Status:" + bool + "  List:" + list));

		print("\n\nSummerizing functions for provided variable");
		// SummarizingDouble Getting statistical values (count sum min max average)
		DoubleSummaryStatistics x = lcust.stream().collect(Collectors.summarizingDouble(person -> person.getIncome()));
		print(x.toString());
		print("Max In Summery: "+x.getMax());
	}

	public static void streamDemoCollectors(List<Customer> lcust) {
		// Collecting to another collection
		print("\nCollecting to list");
		List<Double> lsal = lcust.stream().map(person-> person.getIncome()).collect(Collectors.toList());
		lsal.forEach(System.out::println);

		// Reducing to one val like sum avg
		print("\nGetting sum and Average:");
		Double sum = lcust.stream().map(person -> person.getIncome()).reduce(0d, Double::sum);// Starting value, type:aggre fun
		Double avg = lcust.stream().collect(Collectors.averagingDouble(x -> x.getIncome()));

		System.out.println("Sum of Everyones Income:" + sum + "\nAverage:" + avg);

		// Find max Income by maxBy of Collectors
		Customer customer = lcust.stream().collect(Collectors.maxBy(Comparator.comparing(Customer::getIncome))).get();
		print("\nCustomer with Max Income:"+customer);
		
		// Customer Stream to key as Customer ID and Value as Customer Object 
		Map<Object, Object> custMap = lcust.stream().collect(Collectors.toMap(p->p.getId(), p->p));
		print("\nCustomer Stream to key as Customer ID and Value as Customer Object");
		custMap.forEach((key,value)->System.out.println("Key: "+key+"__value: {"+value+"}"));
	}

	public static void streamDemoBasic(List<Customer> lcust) {
		print("Entered Data:");
		lcust.forEach(System.out::println);

		print("\nFiltered Data (Income>300)");
		lcust.stream().filter(person -> person.getIncome() > 300).forEach(System.out::println);

		print("\nMapping ony names:");
		lcust.stream().map(person-> person.getName()).forEach(System.out::println);
	}
}
