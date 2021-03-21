import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static int solve(int[] t) {
        int len = t.length;
        int []arrOfWaitingAdjust = new int[len];
        int curMax  = 0;
        for (int i = 0; i < len; i++) {
            if (i >= t[i]) { // If waiting at that index less than position
                curMax++;
            }
            arrOfWaitingAdjust[(i+1) % len] += 1;
            arrOfWaitingAdjust[((i+1) - t[i] + len) % len] -= 1;// reverse waiting decreased
        }
        int maxIndex  = 0;
        int maxWaiting = curMax;

        // Maximise waiting so that drawing can be completed
        for (int i = 1;i < len; i++) {
            if ((curMax += arrOfWaitingAdjust[i]) > maxWaiting) {
                maxWaiting = curMax;
                maxIndex = i;
            }
        }
        return maxIndex + 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tCount = Integer.parseInt(scanner.nextLine().trim());

        int[] t = new int[tCount];

        String[] tItems = scanner.nextLine().split(" ");

        for (int tItr = 0; tItr < tCount; tItr++) {
            int tItem = Integer.parseInt(tItems[tItr].trim());
            t[tItr] = tItem;
        }

        int id = solve(t);

        bufferedWriter.write(String.valueOf(id));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
