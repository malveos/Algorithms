import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class CircularSuffixArray {

    private final Integer[] arr;
    private final int legth;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (null == s) throw new IllegalArgumentException();
        legth = s.length();
        arr = new Integer[s.length()];
        for (int i = 0; i < s.length(); i++)
            arr[i] = i;
        
        Arrays.sort(arr, (Integer i1, Integer i2) -> {
            for (int i = 0; i < legth; i++) {
                char c1 = s.charAt((i1 + i)% legth);
                char c2 = s.charAt((i2 + i)% legth);
                if (c1 > c2) return 1;
                if (c1 < c2) return -1;
            }
            return i1.compareTo(i2);
        });
    }

    // length of s
    public int length() {
        return legth;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i >= legth || i < 0) throw new IllegalArgumentException();
        return arr[i];
    }

    // unit testing (required)
    public static void main(String[] args) {
        String s = "BBBBAAAABB";
        CircularSuffixArray csa = new CircularSuffixArray(s);
        
        int[] a = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = csa.index(i);
            StdOut.println("Index of " + i + " is " + a[i]);
        }
    }

}