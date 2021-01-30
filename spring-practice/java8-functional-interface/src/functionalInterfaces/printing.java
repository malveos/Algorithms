package functionalInterfaces;

import java.util.function.Consumer;

/**
 * This is a class implementing Consumer interface for printing using stream
 * 
 * @author omalve
 *
 */
public class printing implements Consumer<Product> {

	@Override
	public void accept(Product t) {
		System.out.println(t);
	}

}