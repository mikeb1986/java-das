package com.boj.das.graphs.algos;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {

        int[][] grid = new int[][]{
            {2, 1, 0, 2, 1},
            {1, 0, 1, 2, 1},
            {1, 0, 0, 2, 1},
        };

        int result = RottenOranges.solve(grid);

        System.out.println(result);

    }

    public static int solve(int[][] grid) {

        Queue<Integer[]> queue = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int iterations = 0;

        // find existing rotten oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    queue.add(new Integer[]{i, j});
                }
            }
        }

        int[][] adjacencies = new int[][]{
            {-1, 0}, {0, -1}, {1, 0}, {0, 1}
        };

        // start bfs
        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean flag = false;
            
            // iterate through each rotten orange
            for (int i = 0; i < size; i++) {
                Integer[] v = queue.poll();

                // inspect each adjancent cell (left, right, top, bottom)
                // if cell is fresh orange, make it rotten, and flag
                // that a fresh orange has become rotten
                for (int j = 0; j < adjacencies.length; j++) {
                    int nRow = v[0] + adjacencies[j][0];
                    int nCol = v[1] + adjacencies[j][1];

                    if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && !visited[nRow][nCol] && grid[nRow][nCol] == 1) {
                        visited[nRow][nCol] = true;
                        grid[nRow][nCol] = 2;
                        queue.add(new Integer[]{nRow, nCol});
                        flag = true;
                    }
                }
            }   

            if (flag) {
                iterations++;
            }

        }

        return iterations;
    }

}
