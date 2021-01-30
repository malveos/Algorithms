package exception;

public class MyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MyException() {
		System.out.println("Unknown Exception Occured!!!!\nPlease, try again");
	}

	public MyException(String message) {
		System.out.println("Error:" + message);
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

}
