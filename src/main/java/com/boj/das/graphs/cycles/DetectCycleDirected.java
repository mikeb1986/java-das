package com.boj.das.graphs.cycles;

import java.util.List;

import com.boj.das.graphs.models.Graph;

public class DetectCycleDirected {

    public static void main(String[] args) {
        int[][] adj = new int[][]{
            {0, 1},
            {1, 2},
            {2, 0},
            {2, 3}
        };

        Graph graph = Graph.fromMat(4, adj, true);

        boolean hasCycle = DetectCycleDirected.hasCycle(graph);
        System.out.println(hasCycle);
    }

    public static boolean hasCycle(Graph graph) {

        List<List<Integer>> adjacencyList = graph.getAdjList();
        int size = graph.getNodes();
        boolean[] visited = new boolean[size];
        boolean[] recStack = new boolean[size];

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                if (hasCycle(i, adjacencyList, visited, recStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasCycle(int node, List<List<Integer>> adjList, boolean[] visited, boolean[] recStack) {

        if (recStack[node]) {
            return true;
        }

        if (visited[node]) {
            return false;
        }

        recStack[node] = true;
        visited[node] = true;

        for (Integer c : adjList.get(node)) {
            if (hasCycle(c, adjList, visited, recStack)) {
                return true;
            }
        }

        recStack[node] = false;

        return false;
    }
}
