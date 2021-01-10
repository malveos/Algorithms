import java.util.regex.*;
import java.util.Scanner;
class RegXMailValidation
{
	protected void validatemail()
	{
		Scanner sc=new Scanner(System.in);
		int i=1;
		while(i==1)
		{
			System.out.print("**************Enter String to validate as mailID*************\n->");
			String in=sc.nextLine();

			Pattern p=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+");
			Matcher m=p.matcher(in);
			if(m.find())
				System.out.println("\tIt is valid mail id");
			else
				System.out.println("\tIt is invalid mail id\n\n");
			System.out.println("Enter q to quit else c");
			String s=sc.nextLine();
			if(s.equalsIgnoreCase("q"))
				i=0;
		}
	}
	protected void validatemobileno()
	{
		Scanner sc=new Scanner(System.in);
		int i=1;
		while(i==1)
		{
			System.out.print("**************Enter Mobile No*************\n->");
			String in=sc.nextLine();

			Pattern p=Pattern.compile("^(0|91)?[7-9]\\d{9}$");
			//instead of using ^ and $ we can check m.group().equals(input)
			Matcher m=p.matcher(in);
			if(m.find())
				System.out.println("\tIt is valid ");
			else
				System.out.println("\tIt is invalid \n\n");
			System.out.println("Enter q to quit else c");
			String s=sc.nextLine();
			if(s.equalsIgnoreCase("q"))
				i=0;
		}
	}
	public static void main(String []args)
	{
		while(true)
		{
			System.out.println("Enter Option:\n1.Validate MailID..\n2.Validate Mobile No..\n3.Exit");
			Scanner sc=new Scanner(System.in);
			int op=sc.nextInt();
			regx x=new regx();
			if(op==3)
				break;
			switch(op)
			{
				case 1:
						x.validatemail();
						break;
				case 2:
						x.validatemobileno();
						break;		
			}
		}	
		
	}
}