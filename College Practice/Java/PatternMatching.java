import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
class PatternMatching {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in) ;
		Pattern p=Pattern.compile("[a-z^D]");
		Matcher m=p.matcher(sc.nextLine());
		
		while(m.find())
		{
			System.out.println(m.start()+"..."+m.end()+"....."+m.group());
		}
	}
}