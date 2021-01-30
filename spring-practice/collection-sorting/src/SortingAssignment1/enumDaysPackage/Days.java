package SortingAssignment1.enumDaysPackage;

/**
 * 
 * @author omalve There are two Enums present here 1. Days- With name and
 *         priority 2. myDays - With name, priority and tasks
 */

// enum is required to set all the days of the week
public enum Days {

	MON("MONDAY", 1), TUE("TUESDAY", 2), WED("WEDNESDAY", 3), THU("THRUSDAY", 4), FRI("FRIDAY", 5), SAT("SATURDAY",
			6), SUN("SUNDAY", 0);

	private Integer priority;
	private String name;

	// Mapping week days to the priority/keys
	Days(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}

	public Integer getPriority() {
		return priority;
	}

	public String getName() {
		return name;
	}
};
