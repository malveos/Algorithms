/***

@Author Omkar Malve

785. Is Graph Bipartite?

There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to. More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:

There are no self-edges (graph[u] does not contain u).
There are no parallel edges (graph[u] does not contain duplicate values).
If v is in graph[u], then u is in graph[v] (the graph is undirected).
The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

Return true if and only if it is bipartite.


***/
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] coloring = new int[n];
        Arrays.fill(coloring, 0);

        for (int i = 0; i < n; i++) {
            if (coloring[i] != 0) continue;

            // check by applying color to remaing node in a sequence
            if (!startChecking(i, graph, coloring)) {
                return false;
            }
        }
        return true;
    }

    private boolean startChecking(int st, int[][] g, int [] coloring) {
        Queue<Integer>  bfs = new LinkedList<>();
        bfs.add(st);
        coloring[st] = 1; // will maintain 2 colors 1 and -1

        while (!bfs.isEmpty()) {
            int cur = bfs.poll();
            for (int adj : g[cur]) {
                // if colored and same color then return false cannot bipartite
                if (coloring[adj] != 0 && coloring[adj] == coloring[cur] && cur != adj)
                    return false;

                // if new then visit with opposite color 
                if (coloring[adj] == 0 ) {
                    coloring[adj] = -1 * coloring[cur];
                    bfs.add(adj);
                }
            }
        }
        return true;
    }
}