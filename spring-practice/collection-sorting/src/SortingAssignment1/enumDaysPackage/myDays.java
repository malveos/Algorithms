package SortingAssignment1.enumDaysPackage;

/**
 * 
 * @author omalve Enum is myDays - With name, priority and tasks
 */

// Enum with task features
public enum myDays {
	MON("MONDAY", 1, "Trekking", false), TUE("TUESDAY", 2, "Bowling", true), WED("WEDNESDAY", 3, "Picknik", true), THU(
			"THRUSDAY", 4, "Movie", false), FRI("FRIDAY", 5, "Gym",
					true), SAT("SATURDAY", 6, "Break", false), SUN("SUNDAY", 0, "Cooking", false);

	private int priority;
	private String name;
	private String task;
	private boolean isAtWork;

	// Mapping week days to the priority/keys
	myDays(String name, int priority, String task, boolean isAtWork) {
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

	public int getPriority() {
		return priority;
	}

	public boolean isAtWork() {
		return isAtWork;
	}
	
	/*public myDays getInfoByPriority(int priority) {
		myDays[] d= myDays.values();
		Stream<myDays> stream = Stream.of(d);
		myDays answer = stream.filter(myDay->myDay.getPriority()==priority);
		
		return null;
	}*/

};
