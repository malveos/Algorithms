package functionalInterfaces;

/**
 * This is a class implementing runnable interface
 * 
 * @author omalve
 *
 */

public class MythreadClass implements Runnable {

	@Override
	public void run() {
		System.out.println("In run method");
	}

}
