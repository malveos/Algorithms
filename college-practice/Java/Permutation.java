import java.util.*;
class Permutation {
	public static ArrayList<String> al=new ArrayList<String>();
	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0){
	      System.out.println(prefix);
	      //if(prefix!=null)
	      	al.add(prefix);  
	    } 
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
	public static void main(String[] args) {
		permutation("",new Scanner(System.in).next());
	}
}