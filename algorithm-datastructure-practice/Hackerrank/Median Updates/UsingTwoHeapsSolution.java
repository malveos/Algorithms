import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class MedianDataStructure {
    private Queue<Long> minHeap, maxHeap;
    MedianDataStructure() {
      minHeap = new PriorityQueue<>();
      maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    void add(long num) {
      if (!minHeap.isEmpty() && minHeap.peek() > num) {
        maxHeap.offer(num);
        if (maxHeap.size() > minHeap.size() + 1) {
          minHeap.offer(maxHeap.poll());
        }
      } else {
        minHeap.offer(num);
        if (maxHeap.size() + 1 < minHeap.size()) {
          maxHeap.offer(minHeap.poll());
        }
      }
    }

    double getMedian() {
      double median;
      DecimalFormat df = new DecimalFormat("#.#");
      if (minHeap.isEmpty() && maxHeap.isEmpty()) {
        System.out.println("Wrong!");
        return 0;
      }

      if (maxHeap.size() > minHeap.size()) {
        median = maxHeap.peek();
      } else if (maxHeap.size() < minHeap.size()) {
        median =  minHeap.peek();
      } else {
        median =  (maxHeap.peek() + minHeap.peek()) /2.0;
      }
      System.out.println(df.format(median));
      return median;
    }

    boolean isNumPresent(long num) {
      return maxHeap.contains(num) || minHeap.contains(num);
    }

    boolean remove(long num) {
       if (maxHeap.isEmpty() && minHeap.isEmpty()) {
         return false;
       }
       if (num > maxHeap.peek()) {
         return minHeap.remove(num);
       } else {
         return maxHeap.remove(num);
       }
    }
  }

class Solution {
  /* Head ends here */

  static void median(String a[], long x[]) {
    
    MedianDataStructure ds = new MedianDataStructure();
    for (int i = 0; i < a.length; i++) {
      String oper = a[i];
      if (oper.equals("a")) {
        ds.add(x[i]);
        ds.getMedian();
      } else {
        if (ds.isNumPresent(x[i])) {
          ds.remove(x[i]);
          ds.getMedian();
        } else {
          System.out.println("Wrong!");
        }
      }
    }
  }

  /* Tail starts here */

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();

    String s[] = new String[N];
    long x[] = new long[N];

    for (int i = 0; i < N; i++) {
      s[i] = in.next();
      x[i] = in.nextLong();
    }
    System.out.println("Ans:");
    median(s, x);
    in.close();
  }
}