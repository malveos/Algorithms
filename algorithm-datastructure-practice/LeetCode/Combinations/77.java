/****
@Author Omkar Malve

Combinations
Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.


****/
class Solution {
    List<List<Integer>> lists;
    public List<List<Integer>> combine(int n, int k) {
        lists = new ArrayList<>();
        List<Integer> comboSize = new ArrayList<>();
        recursion(comboSize, n, k, 1);
        return lists;
    }

    void recursion(List<Integer> comboSize, int n, int k, int start) {
        if(comboSize.size() == k) { // we came to max combination size
            lists.add(new ArrayList(comboSize));
            return ;
        }
        if((k-comboSize.size())>(n-start+1)) // to remove unnecessary computations
			return;
        
        // try for all ramaining add and remove of element
        for(int i = start; i <= n; i++) {
            comboSize.add(i);
            recursion(comboSize,n,k,i+1);
            comboSize.remove(comboSize.size()-1);
        }
    }
}