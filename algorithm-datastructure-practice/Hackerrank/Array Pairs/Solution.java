import java.io.*;
import java.util.*;

public class Solution {

    /**
     * We will solve using (L,R)  L i m j R
     * 
     * left smallerArray: m-L<R-m
     *      For L<=i<=m; find j such m<=j<=R and Aj <= floor (Am/Ai)
     * 
     * left LargerArray: m-L>=R-m
     *      For m<=j<=R; find i such L<=i<=m and Ai <= floor (Am/Aj)

        Then gp for Left and Right Parts

     * @param arr
     * @return
     */
    static long solve(int[] arr) {
        return getCount(arr, 0, arr.length - 1);
    }

    static int getCount(int[] arr, int start, int end) {
        int count = 0;
        if (arr.length < 2)
            return count;
        int midI = maxIdx(arr, start, end);

        if (midI - start < end - midI) {
            for (int i = start; i<=midI; i++) {
                for (int j = midI+1; j<= end; j++) {
                    if(arr[j] <= Math.floorDiv(arr[midI], arr[i])) {
                        count +=1;
                        System.out.print("LPair(" + arr[i] + "," + arr[j] + ")");
                    }
                }
            }
        } else {
            for (int j = midI; j<=end; j++) {
                for (int i = start; i<= midI; i++) {
                    if(arr[i] <= Math.floorDiv(arr[midI], arr[j])) {
                        count +=1;
                        System.out.print("RPair(" + arr[i] + "," + arr[j] + ")");
                    }
                }
            }
        }

        int[] leftA = new int[midI - start];
        for (int i = 0; i < midI - start; i++) {
            leftA[i] = arr[i];
        }
        int[] rightA = new int[end - midI];
        int ct = 0 ;
        for (int i = midI + 1; i <= end; i++) {
            rightA[ct] = arr[i];
            ct+=1;
        }
        System.out.println("left: [" + start + "-" + (midI - 1) + "], (count:" + count + "), right: [" + (midI + 1)
                + "-" + end + "]");
        return getCount(leftA, start, midI - 1) + getCount(rightA, midI + 1, end) + count;
    }

    static int maxIdx(int[] arr, int start, int end) {
        int max = 0;
        int idx = -1;
        // Start at the middle and jump back and forth
        // so we can evenly split the array.
        int i = (start + end) >> 1;
        for (int j = 1, sign = 1; j <= end - start;) {
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
            i += sign * j;
            sign = -sign;
            ++j;
        }
        System.out.println("Finding midMax- <" + start + "-" + end + ">-:" + idx);
        return idx;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        long result = solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
