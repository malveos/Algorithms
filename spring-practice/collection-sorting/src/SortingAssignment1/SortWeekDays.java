package SortingAssignment1;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import SortingAssignment1.enumDaysPackage.Days;
import SortingAssignment1.enumDaysPackage.myDays;


/**
 * 
 * @author omalve 
 * This class provides functionality of sorting week days using
 *
 * 1. Comparator and Enum 
 * 2. Using Map 
 * 3. Using Streams in Java
 * 
 */
public class SortWeekDays {

	// printing with one word
	public void print(String message) {
		System.out.println(message);
	}

	public static void main(String[] args) {

		SortWeekDays swd = new SortWeekDays();

		//swd.sortUsingComparatorAndEnum();
		//swd.sortUsingStream();
		swd.sortingUsingEnumWithTasks();
		//swd.sortingUsingEnumAndArrayListofTasks();

		// Predefined Enum in API
		//swd.directDayOfWeekMethod();
	
	}

	// adding list of tasks to corresponding weekdays
	@SuppressWarnings("serial")
	private void sortingUsingEnumAndArrayListofTasks() {
		Days[] days=Days.values();
		
		Map<Days, ArrayList<String>> tasks = new HashMap<Days, ArrayList<String>>() {
			{
				put(Days.MON, new ArrayList<String>() {
					{
						add("Go to Movie Theater");
						add("Trekking");
					}
				});
				put(Days.TUE, new ArrayList<String>() {
					{
						add("Swiming");
					}
				});
				put(Days.WED, new ArrayList<String>() {
					{
						add("Study");
						add("House cleaning");
					}
				});
				put(Days.THU, new ArrayList<String>() {
					{
						add("MOvie");
					}
				});
				put(Days.FRI, new ArrayList<String>() {
					{
						add("Football");
					}
				});
				put(Days.SAT, new ArrayList<String>() {
					{
						add("Stays Home");
					}
				});
			}
		};
		// sorting according to the keys
		tasks.entrySet().stream().sorted((p1, p2) -> {
			return Integer.signum(p1.getKey().getPriority() - p2.getKey().getPriority());
		}).forEach(System.out::println);
	}

	// Enum with field of tasks
	private void sortingUsingEnumWithTasks() {
		myDays[] arr = myDays.values();
		
		Set<myDays> tasklist = new HashSet<myDays>(Arrays.asList(arr));
		tasklist.stream().sorted((p1, p2) -> {
			return Integer.signum(p1.getPriority() - p2.getPriority());
		}).map(m->m.getTask()).forEach(System.out::println);     //.forEach((p) -> System.out.println(p.getName() + "-" + p.getTask()));
	}

	// Comparator to sort according to the index keys of week days
	private void sortUsingComparatorAndEnum() {
		print("Sorting UsingComparator and Enum");
		
		Comparator<Days> cmp = new Comparator<Days>() {
			@Override
			public int compare(Days arg0, Days arg1) {
				return arg0.getPriority().compareTo(arg1.getPriority());
			}
		};

		Set<Days> st = new TreeSet<>(cmp);
		st.addAll(Arrays.asList(new Days[] { Days.MON, Days.FRI, Days.THU, Days.SUN }));
		st.forEach(System.out::println);
		print("\n\n");
	}

	
	// Stream Sorting
	private void sortUsingStream() {
		print("Sorting Using Stream:");
		Set<Days> st = new TreeSet<>();
		st.addAll(Arrays.asList(new Days[] { Days.MON, Days.FRI, Days.THU, Days.SUN }));
		System.out.println("Values:");
		st.stream().sorted((p1, p2) -> {
			return Integer.signum(p1.getPriority() - p2.getPriority());
		}).forEach(System.out::println);
		print("\n\n");
	}

	// Using Time DAte API we can get directly Set of week days
	private void directDayOfWeekMethod() {
		print("directDayOfWeekMethod");
		DayOfWeek[] dow = DayOfWeek.values();
		for (DayOfWeek d : dow)
			System.out.println(d.minus(1));// Default it starts from Monday'
		print("\n\n");
	}
}
