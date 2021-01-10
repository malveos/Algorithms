import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DecToBinary {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long p=n;
        long pr=1,x=0,ct=0,num=0,tp=1;
        while(n!=0)
        {
            x=n%2;
            num=num+x*tp;
			tp*=10;
			n=n/2;
            
        }
		System.out.println("binary:"+num);
		long max=0;
		while(num!=0)
		{
			x=num%10;
			if(x==1)
			{	
				ct=ct+1;
				System.out.print("->"+ct+"_");
				if(max<ct)
				{	
					System.out.print(":umax"+max+ct);
					max=ct;
				}
				
			}
			else 
			{
				if(max<ct)
				{	
					System.out.print(":max"+max+ct);
					max=ct;
				}
				
				System.out.print("in else::->>"+ct);
				ct=0;
			}
			num=num/10;	
			
		}
			System.out.println(" ::"+(max+0));
    }
}
