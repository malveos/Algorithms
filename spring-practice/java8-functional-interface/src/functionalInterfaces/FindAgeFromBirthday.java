package functionalInterfaces;
import java.time.*;

/**
 * This is class implements Interface of getAge which finds age from given birthday
 * @author omalve
 *
 */
public class FindAgeFromBirthday {

	public static void main(String [] args) {
	
		LambdaReturningAge lr=d->{			
		    LocalDate now = LocalDate.now(); 
		    Period period = Period.between(d, now);
		    return period.getYears();			
		};
		LocalDate birthdate = LocalDate.of(1996, 2, 29);
		int ag=lr.getAge(birthdate);
		System.out.println(ag);
	}
	
}
