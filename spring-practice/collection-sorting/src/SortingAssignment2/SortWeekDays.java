package SortingAssignment2;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import SortingAssignment2.Util.WeekDays;

/**
 * 
 * @author omalve This class provides functionality of sorting week days
 *         starting from the SUNDAY using
 *
 *         1. Comparator and Enum 2. Using Map 3. Using Streams in Java
 * 
 */
public class SortWeekDays {

	public static void main(String[] args) {

		SortWeekDays swd = new SortWeekDays();

		swd.sortUsingComparatorAndEnum();
		swd.sortingUsingComparatorUsedSet();
		swd.displayWeekDaysUsingTimeAPI();
		swd.sortingUsingComparatorUsedMap();
		swd.getWeekDayByPriority();
	}

	private void getWeekDayByPriority() {
		print("\nGet Week Day by Priority");
		WeekDays d = WeekDays.getInfoByPriority(4);
		print("Name: " + d.getName() + "\nTask: " + d.getTask());
	}

	// User defined Comparator given as parameter to treeset
	// sorted according to the priorities mentioned in WeekDays Enum
	private void sortUsingComparatorAndEnum() {
		print("Sorting Using Comparator and Enum");

		Comparator<WeekDays> comparator = new Comparator<WeekDays>() {
			@Override
			public int compare(WeekDays day1, WeekDays day2) {
				return day1.getPriority().compareTo(day2.getPriority());
			}
		};

		WeekDays[] arrayOfWeekDays = WeekDays.values();
		Set<WeekDays> setOfDays = new TreeSet<>(comparator);
		setOfDays.addAll(Arrays.asList(arrayOfWeekDays));
		setOfDays.forEach(System.out::println);
		print("\n\n");
	}

	// WeekDays enum with field of tasks are added to set and then converted to
	// stream
	// for custom sorting according to the priorities mentioned in the WeekDays Enum
	private void sortingUsingComparatorUsedSet() {
		print("Printing Tasks according to days");
		WeekDays[] arrayOfWeekDays = WeekDays.values();
		Set<WeekDays> tasklist = new HashSet<WeekDays>(Arrays.asList(arrayOfWeekDays));
		tasklist.stream().sorted((p1, p2) -> {
			return Integer.signum(p1.getPriority() - p2.getPriority());
		}).map(m -> m.getTask()).forEach(System.out::println);
		// .forEach((p) -> System.out.println(p.getName() + "-" + p.getTask()));
		print("\n");
	}

	// Printing WeekDays using Time Date API in Java 8 where we can get directly
	// Enum of weekdays
	private void displayWeekDaysUsingTimeAPI() {
		print("Display WeekDays UsingTimeAPI in java.time ");
		DayOfWeek[] dow = DayOfWeek.values();
		for (DayOfWeek d : dow)
			System.out.println(d.minus(1));// Default :Sequence starts from Monday'
		print("\n");
	}

	// Here, Map of < priority, Tasks > are added from WeekDays Enum
	private void sortingUsingComparatorUsedMap() {
		WeekDays[] days = WeekDays.values();
		// Map<priority,List<Task>>
		Map<Integer, String> tasks = new HashMap<Integer, String>();
		for (WeekDays weekday : days) {
			tasks.put(weekday.getPriority(), weekday.getTask());
		}
		// Sorting map using streams according to the 'WeekDays' enum priority
		tasks.entrySet().stream().sorted((p1, p2) -> {
			return Integer.signum(p1.getKey().compareTo(p2.getKey()));
		}).forEach((index) -> System.out.println("Key : " + index.getKey() + " -- Value : " + index.getValue()));
	}

	// Printing the string message on console
	public void print(String message) {
		System.out.println(message);
	}
}
