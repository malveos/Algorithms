import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
class StringMatch
{
	public static void main(String[] args) 
	{
		/*
		Scanner sc = new Scanner(System.in) ;
		Pattern p=Pattern.compile("aaa?");
		Matcher m=p.matcher("aabaababaabaaaabaaabbaabbaaa");

		while(m.find())
		{
			System.out.println(m.start()+"..."+m.end()+"....."+m.group());
		}
		*/
		Pattern p=Pattern.compile("[.]");
		String s[]=p.split("a.jij.nuig.nijh.");
		for(String ss:s)
			System.out.println("Strings are:"+ss);

		StringTokenizer st= new StringTokenizer("34:221:2232",":");
		while(st.hasMoreTokens())
			System.out.println("tokens:"+st.nextToken());
	}
}