/***
@Author Omkar Malve

347. Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



***/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> mp = new HashMap<>(nums.length);
        for (int n : nums) {
            if (mp.containsKey(n)) {
                int newC = mp.get(n) + 1;
                mp.put(n, newC);
            } else {
                mp.put(n, 1);
            }
        }
        // finding k most occured
        List<Integer> [] count = new ArrayList[nums.length];
        for (int i = 0; i < nums.length; i++)
            count[i] = new ArrayList<>();

        
        // fill freq Array count
        for (int ele : mp.keySet())
            count[mp.get(ele) - 1].add(ele);

        //System.out.println("CountArray: " + getArrayElem(count));
        //get last k elements fromt he list array for answer
        for (int i = nums.length - 1; i>= 0; i--) {
            while(!count[i].isEmpty() && k > 0) {
                ans[k - 1] = count[i].remove(0);
                k--;
            }
        }
        return ans;
    }

    private String getArrayElem(List<Integer> [] count)   {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> ls : count) {
            sb.append(ls).append(", ");
        }
        return sb.toString();
    }  
}