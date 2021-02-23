import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class DisJointSet {
    int parent[];
    int count[];
    int max = 0;
    int min = 0;

    public DisJointSet(int s) {
        parent = new int[s+1];
        count = new int[s+1];
        for (int i=0; i<s; i++) {
            parent[i] = i;
            count[i] = 1;
        }
        min = s;
    }

    public void union(int left, int right) {
        int rl = find(left);
        int rr = find(right);
        if (rl == rr) return;

        if (count[rl] < count[rr]) {
            parent[rl] = rr;
            count[rr] += count[rl];
            count[rl] = 0;
            if (count[rr] > max) {
                max = count[rr];
            }
        } else {
            parent[rr] = rl;
            count[rl] += count[rr];
            count[rr] = 0;
            if (count[rl] > max) {
                max = count[rl];
            }
        }
    }

    public int find(int node) {
        int root = node;
        while (root!=parent[root])
            root = parent[root];
        return root;
    }

    public int size(int node) {
        int parent = find(node);
        return count[parent];        
    }

    public boolean isConnected(int left, int right) {
        return (find(left) == find(right));
    }

    public int getMinSize() {
        for (int c: count) {
            if(c >1 && c < min) {
                min = c;
            }
        }
        return min;
    }

    public int getMaxSize() {
        return max;
    }
}

class Result {

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
        int edges = gb.size() * 2 + 1;
        DisJointSet ds = new DisJointSet(edges);
        for (List<Integer> edge : gb) {
            ds.union(edge.get(0), edge.get(1));
        }
        List<Integer> ans = new LinkedList<>();
        ans.add(ds.getMinSize());
        ans.add(ds.getMaxSize());        
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> gb = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                gb.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.componentsInGraph(gb);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
