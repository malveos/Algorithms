import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static long solve(int[] arr) {
        int len = arr.length;

        Stack<Integer> stack = new Stack<>();
        int[] r = new int[len];
        int[] l = new int[len];

        l[0] = 0;
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i])
                stack.pop();

            if (!stack.isEmpty())
                l[i] = stack.peek() + 1;
            else
                l[i] = 0;
            stack.push(i);            
        }

        stack.clear();
        r[len -1] = 0;
        stack.push(len - 1);
        for (int i = len - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i])
                stack.pop();

            if (!stack.isEmpty())
                r[i] = stack.peek() + 1;
            else
                r[i] = 0;
            stack.push(i);            
        }

        long max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, (long)r[i] * l[i]);
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        long result = solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
           