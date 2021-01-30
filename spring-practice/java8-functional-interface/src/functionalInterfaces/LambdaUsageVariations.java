package functionalInterfaces;

/**
 * This class gives the implementation of lambda expression with different ways
 * 
 * @author omalve
 *
 */
public class LambdaUsageVariations {
	public static void main(String[] args) {

		LambdaUsageVariations use = new LambdaUsageVariations();

		use.withoutLamda();
		use.withLamda();
		use.withAnnonymusClass();
		use.myInterfaceRun();
		use.myInterfaceRunLambda();
		use.FuntionalInterfaceWithAgrs();
	}

	// functional interface with argument using lambda
	private void FuntionalInterfaceWithAgrs() {
		InterfaceWithArguments ir = (String n, int r) -> {
			System.out.println("Name is:" + n + "\nRol no is:" + r + "------------------");
		};
		ir.twoArgs("Omkar", 54);
	}

	// functional interface using lambda
	private void myInterfaceRunLambda() {
		SampleInterface r = () -> System.out.println("Printing using lambda");
		r.sample();
	}

	// functional interface with anonymous class
	private void myInterfaceRun() {
		SampleInterface r = new SampleInterface() {
			public void sample() {
				System.out.println("Custom interface with annonymus class");
			}

		};
		r.sample();
	}

	// functional interface runnable
	private void withAnnonymusClass() {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("Using annonymus class");
			}
		};
		Thread th = new Thread(r);
		th.start();
	}

	// functional interface runnable using lambda
	private void withLamda() {
		Runnable r = () -> System.out.println("Run using lambda ");
		Thread th = new Thread(r);
		th.start();
	}

	// Normal implementation with the class implementing runnable interface
	private void withoutLamda() {
		MythreadClass t = new MythreadClass();
		Thread th = new Thread(t);
		th.start();
	}
}
