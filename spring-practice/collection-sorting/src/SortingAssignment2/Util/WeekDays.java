package SortingAssignment2.Util;

import java.util.stream.Stream;

/**
 * 
 * @author omalve 
 * Enum is WeekDays - With name, priority, tasks, location
 */

// Enum with task features
public enum WeekDays {
	MON("MONDAY", 1, "Trekking", false), TUE("TUESDAY", 2, "Bowling", true), WED("WEDNESDAY", 3, "Picknik", true), THU(
			"THRUSDAY", 4, "Movie", false), FRI("FRIDAY", 5, "Gym",
					true), SAT("SATURDAY", 6, "Break", false), SUN("SUNDAY", 0, "Cooking", false);

	private Integer priority;
	private String name;
	private String task;
	private boolean isAtWork;

	// Mapping week days to the priority/keys
	WeekDays(String name, int priority, String task, boolean isAtWork) {
		this.priority = priority;
		this.name = name;
		this.task = task;
		this.isAtWork = isAtWork;
	}

	public String getTask() {
		return task;
	}

	public String getName() {
		return name;
	}

	public Integer getPriority() {
		return priority;
	}

	public boolean isAtWork() {
		return isAtWork;
	}
	
	public static WeekDays getInfoByPriority(int priority) {
		WeekDays[] d= WeekDays.values();
		Stream<WeekDays> stream = Stream.of(d);
		WeekDays requiredWeekDay =  stream.filter(myDay->myDay.getPriority()==priority).findFirst().get();
		return requiredWeekDay;
	}

};
