import java.util.*;
class HashMap
{
	public static void main(String[] args) {
		Map<Integer, String> m=new HashMap<Integer, String>();
		System.out.println("Enter int_key and value:");
		int k=new Scanner(System.in).nextInt();
		String str=new Scanner(System.in).next();

		m.put(k,str);
		System.out.println(m.containsKey(3));
		System.out.println(m.size());
		System.out.println(m.containsValue("omkar"));
		System.out.println(m.get(3));
		System.out.println(m.remove(3));
		System.out.println(m.isEmpty());

	}
}