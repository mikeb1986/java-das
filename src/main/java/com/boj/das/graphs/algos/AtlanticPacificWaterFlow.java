package com.boj.das.graphs.algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AtlanticPacificWaterFlow {

    public static void main(String[] args) {
        int[][] mat = new int[][]{
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };

        List<Integer[]> results = AtlanticPacificWaterFlow.solve(mat);
        results.forEach(r -> System.out.println(String.format("{%d, %d}", r[0], r[1])));
    }

    public static List<Integer[]> solve(int[][] mat) {

        // do bfs along top and left edges of mat
        // store visited map
        
        // do bfs along right and bottom edges of mat
        // store visited map

        int rows = mat.length;
        int cols = mat[0].length;

        boolean[][] v1 = new boolean[rows][cols];
        boolean[][] v2 = new boolean[rows][cols];

        // bfs on row 0, all columns
        for (int i = 0; i < cols; i++) {
            bfs(0, i, v1, mat);
        }
        // bfs on all rows, column 0
        for (int i = 0; i < rows; i++) {
            bfs(i, 0, v1, mat);
        }

        // bfs on all rows, last column
        for (int i = 0; i < rows; i++) {
            bfs(i, cols - 1, v2, mat);
        }
        // bfs on all columsn, last row
        for (int i = 0; i < cols; i++) {
            bfs(rows - 1, i, v2, mat);
        }

        List<Integer[]> results = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (v1[i][j] && v2[i][j]) {
                    results.add(new Integer[]{i, j});
                }
            }
        }

        return results;
    
    }

    private static void bfs(int row, int col, boolean[][] visited, int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{row, col});
        visited[row][col] = true;

        int[][] adjs = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        while (!queue.isEmpty()) {
            // traverse the adjacent nodes
            Integer[] cn = queue.poll(); // current node
            for (int i = 0; i < adjs.length; i++) {
                int nr = cn[0] + adjs[i][0]; // new row
                int nc = cn[1] + adjs[i][1]; // new col
                // if new position is valid within mat and not yet visited
                // and is a larger number than the current node, then we can traverse it
                if (nr >= 0 && nr < rows & nc >= 0 && nc < cols && !visited[nr][nc] && mat[nr][nc] >= mat[cn[0]][cn[1]]) {
                    visited[nr][nc] = true;
                    queue.add(new Integer[]{nr, nc});
                }
            }
        }

    }

}
