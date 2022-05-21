/**

@Authro Omkar Malve

119. Pascal's Triangle II

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

**/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        // Consider right slant for our calcuation
        List<List<Integer>> ans = new ArrayList<>();

        for (int i  = 0; i < rowIndex + 1; i++) {
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
        return ans.get(rowIndex);
    }
}