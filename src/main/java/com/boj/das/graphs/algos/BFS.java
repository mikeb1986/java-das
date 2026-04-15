package com.boj.das.graphs.algos;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.boj.das.graphs.models.Graph;

public class BFS {

    public static void main(String[] args) {
        Graph graph = Graph.fromMat(4, Graph.SAMPLE_MAT, false);
        BFS.bfs(graph.getAdjList(), 4);
    }

    public static void bfs(List<List<Integer>> adjList, int nodes) {
        boolean[] visited = new boolean[nodes];
        Queue<Integer> queue = new LinkedBlockingQueue<>();

        queue.add(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int v = queue.poll();
            
            System.out.println(v);

            for (Integer adj : adjList.get(v)) {
                if (!visited[adj]) {
                    visited[adj] = true;
                    queue.add(adj);
                }
            }
        }
    }

}
