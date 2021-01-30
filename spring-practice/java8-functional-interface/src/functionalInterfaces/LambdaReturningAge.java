package functionalInterfaces;

/**
 * This is a functional interface declares method of getting current age
 * 
 * @author omalve
 *
 */

@FunctionalInterface
public interface LambdaReturningAge {
	int getAge(java.time.LocalDate d);
}
