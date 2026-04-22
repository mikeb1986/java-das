package com.boj.das.graphs.algos;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public static void main(String[] args) {
        int[][] data = new int[][]{
            {1, 1, 1, 0},
            {0, 1, 1, 1},
            {1, 0, 1, 1},
        };

        FloodFill.print(data);

        FloodFill.fill(data, 1, 2, 2);

        FloodFill.print(data);
    }

    public static void print(int[][] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                sb.append(data[i][j]).append(",");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void fill(int[][] grid, int sr, int sc, int newColor) {

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Integer[]> queue = new LinkedList<>();
        int originalColor = grid[sr][sc];
        grid[sr][sc] = newColor;

        int[][] adjacencies = new int[][]{
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        queue.add(new Integer[]{sr, sc});

        while (!queue.isEmpty()) {
            Integer[] v = queue.poll();

            for (int i = 0; i < adjacencies.length; i++) {
                int nr = v[0] + adjacencies[i][0];
                int nc = v[1] + adjacencies[i][1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && originalColor == grid[nr][nc]) {
                    grid[nr][nc] = newColor;
                    queue.add(new Integer[]{nr, nc});

                }
            }
        }

    }    

}
