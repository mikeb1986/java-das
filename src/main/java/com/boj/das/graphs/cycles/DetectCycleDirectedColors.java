package com.boj.das.graphs.cycles;

import java.util.List;

import com.boj.das.graphs.models.Graph;

public class DetectCycleDirectedColors {

    public static void main(String[] args) {

        int[][] mat1 = new int[][]{
            {0, 1},
            {0, 2},
            {1, 2},
            {2, 0},
            {2, 3},
            {3, 3}
        };

        int[][] mat2 = new int[][]{
            {0, 1},
            {0, 2},
            {1, 2},
            {2, 3}
        };        

        Graph graph1 = Graph.fromMat(4, mat1, true);
        Graph graph2 = Graph.fromMat(4, mat2, true);

        boolean r1 = DetectCycleDirectedColors.hasCycle(graph1);
        boolean r2 = DetectCycleDirectedColors.hasCycle(graph2);

        System.out.println(r1);
        System.out.println(r2);
    }

    public static boolean hasCycle(Graph graph) {
        
        int[] colors = new int[graph.getNodes()];
        for (int i = 0; i < graph.getNodes(); i++) {
            if (hasCycleDfs(i, graph.getAdjList(), colors)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCycleDfs(int node, List<List<Integer>> adjList, int[] colors) {
        int white = 0, gray = 1, black = 2;

        colors[node] = gray;

        for (int adj : adjList.get(node)) {
            if (colors[adj] == gray) {
                return true;
            } else if (colors[adj] == white && hasCycleDfs(adj, adjList, colors)) {
                return true;
            }
        }

        colors[node] = black;

        return false;
    }

}
