import javax.swing.*;
import java.io.*;
class PrefixTOPostfix
{
	public static String fun(String x)
	{
		int i=0;
		if(x.length()==1)
			return x;

		String op=x.charAt(0)+"";
		x=x.substring(1);
														
		for(i=0;i<x.length()-1;i++)
		{
			if(isChar(x.charAt(i))&&isOp(x.charAt(i+1)))
				{
					i++;
					break;
				}
		}
		if(i==x.length()-1)
			return x+op;
		
		String s1=fun(x.substring(0,i));
		String s2=fun(x.substring(i));
		
		return s1+s2+op;
	}
	protected static boolean isOp(char c)
	{
		if(c=='-'||c=='+'||c=='*'||c=='/'||c=='^')
			return true;
		else 
			return false;
	}
	protected static boolean isChar(char c)
	{
		if((c>=48&&c<=57)||(c>=65&&c<=91)||(c>=97&&c<=123))
			return true;
		else
			return false;
	}
	public static void main(String[] args) throws Exception{
		String p=new BufferedReader(new InputStreamReader(System.in)).readLine();//JOptionPane.showInputDialog(null,"Enter String:");
		//JOptionPane.showMessageDialog(null,"PostFix-->"+fun(p));
		System.out.println("Post:->"+fun(p));
	}
}