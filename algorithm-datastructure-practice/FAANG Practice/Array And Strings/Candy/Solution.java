/**

@Author Omakr Malve

135. Candy

There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.

***/
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int [] candies = new int[n];

        // left to right assign
        candies[0] = 1;
        for (int i = 1 ; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
            else
                candies[i] = 1;
        }

        // right to left assign
        for (int i = n - 2 ; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1])
                candies[i] = candies[i + 1] + 1;
        }
        int total = 0;
        for (int c: candies)
            total+=c;
        return total;
    }
}