import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

class BinaryIndexTree {
    private final int [] elem;
    private final int sz;

    BinaryIndexTree(int n) {
        sz = n;
        elem = new int[n];
    }

    public int getSum(int idx) {
        int sum = 0;
        idx += 1;
        while (idx>0) {
            sum+=elem[idx]; 
            idx -= idx & (-idx);
        }
        return sum; 
    }

    public void add(int idx, int val) {
        idx = idx + 1; 

        while(idx <= sz) {
            elem[idx] += val;
            idx += idx & (-idx); 
        }
    }
}

public class Solution {

    // Complete the solve function below.
    static int solve(int[][] shots, int[][] players) {
        BinaryIndexTree aTree = new BinaryIndexTree(100000);
        BinaryIndexTree bTree = new BinaryIndexTree(100000);

        for (int i = 0;i < shots.length; i++) {
            aTree.add(shots[i][0], 1);
            bTree.add(shots[i][1], 1);
        }

        int sum = 0;
        int m = players.length;
        for (int i = 0; i < m; i++) {
            sum += m - bTree.getSum(players[i][0]-1) - (m - aTree.getSum(players[i][1]));
        }
        System.out.println(sum);
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] shots = new int[n][2];

        for (int shotsRowItr = 0; shotsRowItr < n; shotsRowItr++) {
            String[] shotsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int shotsColumnItr = 0; shotsColumnItr < 2; shotsColumnItr++) {
                int shotsItem = Integer.parseInt(shotsRowItems[shotsColumnItr]);
                shots[shotsRowItr][shotsColumnItr] = shotsItem;
            }
        }

        int[][] players = new int[m][2];

        for (int playersRowItr = 0; playersRowItr < m; playersRowItr++) {
            String[] playersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int playersColumnItr = 0; playersColumnItr < 2; playersColumnItr++) {
                int playersItem = Integer.parseInt(playersRowItems[playersColumnItr]);
                players[playersRowItr][playersColumnItr] = playersItem;
            }
        }

        int result = solve(shots, players);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
