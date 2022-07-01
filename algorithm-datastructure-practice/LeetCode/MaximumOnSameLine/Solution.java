/***

@Author Omkar Malve

149. Max Points on a Line

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.


***/
class Solution {
    public int maxPoints(int[][] points) {
        return considerThreePoints(points);        
    }

    private int considerThreePoints(int[][] points) {
        int n = points.length;
        int ct = 0;
        int ans = n <= 2 ? n : 1;
        for (int i = 0; i < n - 2; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n - 1; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                ct = 2;
                for (int k = j + 1; k < n; k++) {
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    if (onSameLine(x1, y1, x2, y2, x3, y3)) ct++;
                }
                ans = Math.max(ans, ct);
            }
        }
        return ans;
    }

    private boolean onSameLine(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y2 - y1) *(x3 - x1) == (y3 - y1) * (x2 - x1);
    }

    private int considerSlopWithTwo(int[][] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;

        int total = points.length;
        int ans = 0;
        // xslop -> yslop -> count
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < total; i++) {
            map.clear();
            int same = 0, max = 0;
            for (int j = i + 1; j < total; j++) {
                int xdiff = points[j][0] - points[i][0];
                int ydiff = points[j][1] - points[i][1];
                // cases for numerator and denomenator
                if (xdiff == 0 && ydiff == 0) {
                    same++;
                    continue;
                }
                int gcd = getGCD(xdiff, ydiff);
                if (gcd != 0) {
                    xdiff /= gcd;
                    ydiff /= gcd;
                }
                
                // maintaining slop in a hashmap
                if (map.containsKey(xdiff)) {
                    if (map.get(xdiff).containsKey(ydiff)) {
                        map.get(xdiff).put(ydiff, map.get(xdiff).get(ydiff) + 1);
                    } else {
                        map.get(xdiff).put(ydiff, 1);
                    }
                } else {
                    Map<Integer, Integer> mp = new HashMap<>();
                    mp.put(ydiff, 1);
                    map.put(xdiff, mp);
                }
                max = Math.max(max, map.get(xdiff).get(ydiff));
            }
            ans = Math.max(ans, max + same + 1);// same count and one for start point to calculate whole thing
        }
        return ans;
    }

    private int getGCD(int x, int y) {
        if (y == 0) return x;
        return getGCD(y, x % y);
    }
}