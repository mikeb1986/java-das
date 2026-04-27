package com.boj.das.graphs.algos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SnakeLadderMinThrows {

    public static void main(String[] args) {
        Map<Integer, Integer> movesMap = new HashMap<>();
        movesMap.put(2, 21);
        movesMap.put(4, 7);
        movesMap.put(10, 25);
        movesMap.put(19, 28);

        movesMap.put(26, 0);
        movesMap.put(20, 8);
        movesMap.put(16, 3);
        movesMap.put(18, 6);

        int result = SnakeLadderMinThrows.solve(movesMap, 30);

        System.out.println(result);
    }

    public static int solve(Map<Integer, Integer> movesMap, int boardSize) {
        
        Queue<Integer[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[boardSize];

        // for each position in the queue, move 1-6 times
        // and see where it lands, if lands on a position not yet
        // visited, add the new position to the queue
        // if we have landed on a position >= boardSize, we have reached the end

        queue.add(new Integer[]{0, 0});
        visited[0] = true;

        while(!queue.isEmpty()) {
            Integer[] position = queue.poll();
            int c = position[0]; // current board position
            int m = position[1]; // current number of moves
            
            // if the current position is at the end, we can exit
            if (c >= (boardSize - 1)) {
                return m;
            }

            // roll dice 6 times
            for (int i = 1; i <= 6 && (c + i < boardSize); i++) {
                int nc = c + i; // new board position
                
                // check if new board position is snake or ladder and adjust accordingly
                if (movesMap.containsKey(nc)) {
                    nc = movesMap.get(nc);
                }

                if (!visited[nc]) {
                    visited[nc] = true;
                    queue.add(new Integer[]{nc, m + 1});
                }
            }
        }

        return -1;
        
    }

}
