/***

@Author Omkar Malve

1423. Maximum Points You Can Obtain from Cards

There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.
Given the integer array cardPoints and the integer k, return the maximum score you can obtain.



***/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        return maxScoreByCheckingEverySide(cardPoints, k);
    }

    public int maxScoreByCheckingEverySide(int[] cardPoints, int k) {
        int total = 0, n = cardPoints.length;
        
        for(int i = 0; i < n; i++) {
            total += cardPoints[i];
        }
        int cur = 0;
        for(int i = 0; i < n - k; i++) {
            cur += cardPoints[i];
        }
        int ans = total - cur; 
        for(int i = 0, j = n - k; j < n; i++, j++) {
            cur += cardPoints[j];
            cur -= cardPoints[i];
            ans = Math.max(ans, total - cur);
        }
        return ans;
    }

     private int maxScoreByMAxFromEnd(int[] cardPoints, int k) {
        int i = 0, j = cardPoints.length - 1;
        int ans = 0;
        while(k > 0) {
            if(cardPoints[i] > cardPoints[j]) {
                System.out.println("Adding " + cardPoints[i]);
                ans += cardPoints[i++];
            } else {
                System.out.println("Adding " + cardPoints[j]);
                ans += cardPoints[j--];
            }
            k--;
        }
        return ans;
    }
}