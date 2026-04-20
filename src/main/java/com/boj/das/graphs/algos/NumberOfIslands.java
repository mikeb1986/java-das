package com.boj.das.graphs.algos;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static char[][] grid = {
        {'L', 'W', 'W', 'W', 'L'},
        {'L', 'W', 'L', 'W', 'L'},
        {'L', 'W', 'W', 'W', 'L'}
    };

    public static void main(String[] args) {
        int result = NumberOfIslands.solveBFS(grid);
        System.out.println(result);

        result = NumberOfIslands.solveDFS(grid);
        System.out.println(result);
    }

    public static int solveBFS(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        boolean[][] visited = new boolean[rows][cols];

        // we go through every element, if we find one
        // which is L and is not yet visited, we mark it as
        // a new island and perform bfs on it

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(grid, i, j, visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    public static int solveDFS(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        boolean[][] visited = new boolean[rows][cols];

        // we go through every element, if we find one
        // which is L and is not yet visited, we mark it as
        // a new island and perform bfs on it

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    visited[i][j] = true;
                    dfs(grid, i, j, visited);
                    islands++;
                }
            }
        }

        return islands;
    }

    public static void bfs(char[][] grid, int row, int col, boolean[][] visited) {
        
        int[][] adjacencies = {
            {-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            for (int i = 0; i < adjacencies.length; i++) {
                int nRow = v[0] + adjacencies[i][0];
                int nCol = v[1] + adjacencies[i][1];
                if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && !visited[nRow][nCol] && grid[nRow][nCol] == 'L') {
                    visited[nRow][nCol] = true;
                    queue.add(new int[]{nRow, nCol});
                }
            }
        }
    }

    public static void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        int[][] adjacencies = {
            {-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}
        };
        
        for (int i = 0; i < adjacencies.length; i++) {
            int nRow = row + adjacencies[i][0];
            int nCol = col + adjacencies[i][1];
            if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && !visited[nRow][nCol] && grid[nRow][nCol] == 'L') {
                visited[nRow][nCol] = true;
                dfs(grid, nRow, nCol, visited);
            }            
        }
    }

}
