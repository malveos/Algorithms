/***

@Author Omkar Malve
Mulple of 3

= 2^k if k even  = 1 eles 2 acc to binomaial.


**/
Class Solution {
	public boolean ifMultipleOf3(String n) {
		for (int i = 0; i < n.length; i++) {
			if (i%2 == 0 && n.charAt(i) == '1') evn++;
			if (i%2 != 0 && n.charAt(i) == '1') odd++;
		}
		
		return (2 * odd + evn)%3 == 0;
	}
}