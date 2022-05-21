/***

@Author OMkar Malve

118. Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


***/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        // Consider right slant for our calcuation
        List<List<Integer>> ans = new ArrayList<>();

        for (int i  = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i)
                    row.add(1);
                else
                    // fetch from prev row
                    row.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j - 1));
            }
            ans.add(row);
        }
        return ans;
    }
}