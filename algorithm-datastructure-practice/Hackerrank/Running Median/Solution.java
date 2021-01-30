import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

 class RunningMedian {
        private final PriorityQueue<Integer> maxHeap;
        private final PriorityQueue<Integer> minHeap;
        private Double median = 0.0;
        
        public RunningMedian() {
            maxHeap = new PriorityQueue<>();
            minHeap = new PriorityQueue<>(Collections.reverseOrder());    
        }

        public void insert(int element) {
            if (maxHeap.size() == minHeap.size()) {
                if (element > median) {
                    maxHeap.add(element);
                    median = maxHeap.peek() * 1.0;
                } else {
                    minHeap.add(element);
                    median = minHeap.peek() * 1.0;
                }                 
            } else if (maxHeap.size() > minHeap.size()) {
                if (element > median) {
                    maxHeap.add(element);
                    minHeap.add(maxHeap.poll());
                    median = getMid(maxHeap, minHeap);
                } else {
                    minHeap.add(element);
                    median = getMid(maxHeap, minHeap);
                }
            } else {
                if (element > median) {
                    maxHeap.add(element);
                    median = getMid(maxHeap, minHeap);
                } else {
                    minHeap.add(element);
                    maxHeap.add(minHeap.poll());
                    median = getMid(maxHeap, minHeap);
                }
            }
        }

        private Double getMid(PriorityQueue<Integer> q1, PriorityQueue<Integer> q2) {
            return (q1.peek() + q2.peek()) / 2.0;
        }

        public Double getMedian() {
           return median;
        }
    }


public class Solution {
   
    static double[] runningMedian(int[] a) {
        RunningMedian rm = new RunningMedian();
        double[] medians = new double[a.length];
        NumberFormat formatter = new DecimalFormat("#0.0");  
        for (int i =0; i<a.length; i++) {
            rm.insert(a[i]);
            medians[i] = (rm.getMedian());
        }
        return medians;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
