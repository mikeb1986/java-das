package com.boj.das.graphs.algos;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    public static void main(String[] args) {


        String start = "toon";
        String end = "plea";
        String[] arr = new String[]{
            "poon", "plee", "same", "poie", "plea", "plie", "poin"
        };

        int result = WordLadder.solve(arr, start, end);
        System.out.println(result);

        start = "abcv";
        end = "ebad";
        arr = new String[]{
            "abcd", "ebad", "ebcd", "xyza"
        };

        result = WordLadder.solve(arr, start, end);
        System.out.println(result);        
    }

    public static int solve(String[] arr, String start, String end) {

        // while the queue has an item in it
        // take item from queue, iterate through each character in the string
        // iterate a-z, replacing current character with new character
        // check if word exists in wordSet, if so, increase chain
        // if word equals end, then stop, else put new word in queue and remove from wordSet

        Set<String> wordSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int result = 1;

        for (String s : arr) {
            wordSet.add(s);
        }

        queue.add(start);

        while (!queue.isEmpty()) {
            String s = queue.poll();
            char[] sChar = s.toCharArray();
            
            for (int i = 0; i < sChar.length; i++) {
                char originalChar = sChar[i];
                for (char r = 'a'; r <= 'z'; r++) {
                    sChar[i] = r;
                    String newS = new String(sChar);
                    if (!wordSet.contains(newS)) {
                        continue;
                    }

                    result++;

                    if (newS.equals(end)) {    
                        return result;
                    }

                    wordSet.remove(newS);
                    queue.add(newS);
                }
                sChar[i] = originalChar;
            }
        }

        return 0;
    }

}
