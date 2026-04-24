package com.boj.das.graphs.algos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.boj.das.graphs.models.Graph;

public class Bipartite {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        boolean result = Bipartite.solveDFS(4, edges);
        System.out.println(result);

        result = Bipartite.solveBFS(4, edges);
        System.out.println(result);

        edges = new int[][]{
            {0, 1}, {1, 2}, {2, 3}
        };

        result = Bipartite.solveDFS(4, edges);
        System.out.println(result);

        result = Bipartite.solveBFS(4, edges);
        System.out.println(result);        
    }

    public static boolean solveBFS(int nodes, int[][] edges) {
        Graph graph = Graph.fromMat(nodes, edges, false);
        
        int[] colors = new int[nodes];
        Arrays.fill(colors, -1);

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nodes; i++) {
            if (colors[i] == -1) {
                queue.add(i);
                colors[i] = 1;

                while (!queue.isEmpty()) {
                    int n = queue.poll();
                    for (int j = 0; j < graph.getAdjList().get(n).size(); j++) {
                        int sibling = graph.getAdjList().get(n).get(j);
                        if (colors[sibling] == -1) {
                            colors[sibling] = 3 - colors[n];
                            queue.add(sibling);
                        } else if (colors[sibling] == colors[n]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static boolean solveDFS(int nodes, int[][] edges) {

        Graph graph = Graph.fromMat(nodes, edges, false);
        
        int[] colors = new int[nodes];
        Arrays.fill(colors, -1);

        boolean result = true;
        // dfs each node to get the result
        for (int i = 0; i < nodes; i++) {
            if (colors[i] == -1) {
                colors[i] = 1;
                result = dfs(i, graph.getAdjList(), colors);
                if (!result) {
                    break;
                }   
            }
        }

        return result;
    }

    public static boolean dfs(int node, List<List<Integer>> adjacencyList, int[] colors) {
        boolean result = true;

        for (Integer adj : adjacencyList.get(node)) {
            if (colors[adj] == -1) {
                colors[adj] = 3 - colors[node]; // 3 - 2 = 1 or 3 - 1 = 2
                result = dfs(adj, adjacencyList, colors);
            } else {
                result = colors[adj] != colors[node];
            }

        }

        return result;
    }
}
