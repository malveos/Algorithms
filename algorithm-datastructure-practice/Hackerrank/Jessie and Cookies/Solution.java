import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int len = A.length;
        for (int i = 0; i<len; i++)
            minHeap.add(A[i]);
            
        int requiredOps = 0;
        while(minHeap.size() > 1) {
            if(minHeap.peek() >= k) {
                return requiredOps;
            } else {
                int newV = minHeap.poll() + 2 * minHeap.poll();
               // System.out.println("Inserting-" + newV);
                minHeap.add(newV);
                requiredOps +=1;
            }
        }        
        return (minHeap.size()> 0 && minHeap.peek()>=k) ? requiredOps : -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
