package com.boj.das.graphs.cycles;

import java.util.List;

import com.boj.das.graphs.models.Graph;

public class DetectCycleUndirected {

    public static void main(String[] args) {
        int[][] adj = new int[][]{
            {0, 1},
            {1, 2},
            {2, 0},
            {2, 3}
        };

        Graph graph = Graph.fromMat(4, adj, false);
        boolean result = DetectCycleUndirected.hasCycle(graph);
        
        System.out.println(result);
    }

    public static boolean hasCycle(Graph graph) {
        
        boolean[] visited = new boolean[graph.getNodes()];
        for (int i = 0; i < graph.getNodes(); i++) {
            if (!visited[i] && hasCycleDFS(i, graph.getAdjList(), visited, -1)) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasCycleDFS(int node, List<List<Integer>> adjList, boolean[] visited, int parent) {
        
        visited[node] = true;

        for (Integer child : adjList.get(node)) {
            if (!visited[child]) {
                if (hasCycleDFS(child, adjList, visited, node)) {
                    return true;
                }
            } else if (child != parent) {
                return true;
            }
        }

        return false;
    }

}
