package com.boj.das.graphs.models;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public static final int[][] SAMPLE_MAT = {
        {0, 1},
        {0, 2},
        {1, 3},
        {2, 3},
    };

    private List<List<Integer>> adjList = new ArrayList<>();

    private int nodes;

    public List<List<Integer>> getAdjList() {
        return adjList;
    }

    public int getNodes() {
        return nodes;
    }

    /**
     * Returns a newly constructed graph having it's adjaceny list
     * populated with the edges of mat
     * 
     * @param nodes
     * @param mat
     * @param isDirected
     * @return Graph
     */
    public static Graph fromMat(int nodes, int[][] mat, boolean isDirected) {
        Graph graph = new Graph();
        graph.nodes = nodes;

        for (int i = 0; i < nodes; i++) {
            graph.adjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < mat.length; i++) {
            int k = mat[i][0];
            int v = mat[i][1];

            graph.adjList.get(k).add(v);
            
            if (!isDirected) {
                graph.adjList.get(v).add(k);
            }
        }

        return graph;
    }

}
