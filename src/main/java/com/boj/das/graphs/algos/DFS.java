package com.boj.das.graphs.algos;

import java.util.List;

import com.boj.das.graphs.models.Graph;

public class DFS {

    public static void main(String[] args) {
        Graph graph = Graph.fromMat(4, Graph.SAMPLE_MAT, false);

        boolean[] visited = new boolean[graph.getNodes()];

        DFS.dfs(graph.getAdjList(), 0, visited);
    }

    public static void dfs(List<List<Integer>> adjList, int currentNode, boolean[] visited) {
        visited[currentNode] = true;

        System.out.println(currentNode);

        for (int adjNode : adjList.get(currentNode)) {
            if (!visited[adjNode]) {
                dfs(adjList, adjNode, visited);
            }
        }
    }

}
