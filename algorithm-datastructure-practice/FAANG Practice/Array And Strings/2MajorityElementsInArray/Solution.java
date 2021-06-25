/**
Find 2 Mejarity elements greater than (n/3)


**/
class Solution {
    public List<Integer> majorityElements(int[] nums) {
        int n  = nums.length;
        int ele1 = 0, ct1 = 0, ele2 = 0, ct2 = 0;
        for(int num : nums) {
            if(num == ele1) {
                ct1++;
            } else if(num == ele2) {
                ct2++
            } else if(ct1 == 0) {
				ele1 = num;
				ct1++;
			} else if(ct2 ==0) {
				ele2 = num;
				ct2++;
			} else {
                ct1--;
				ct2--;
            }
        }
		
		// VErification if occurance is greater than n/3
		ct1= 0; ct2 =0;
		for(int num: nums) {
			if(num == ele1)
				ct1++;
			else if(num == ele2) 
				ct2++;
		}
		List<Integer> ans = new ArrayList<>(2);
		if (ct1 > (n/3))
			ans.add(ele1);
		if( ct2 > (n/3))
			ans.add(ele2);
			
        return ans;
    }
}