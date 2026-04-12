package com.boj.das.binarytrees.algos;

import com.boj.das.binarytrees.model.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BFS {

    public static void main(String[] args) {
        BFS.bfs(BinaryTree.getSampleTree());
    }

    public static void bfs(BinaryTree bt) {

        Queue<BinaryTree.Node> queue = new LinkedBlockingQueue<>();
        queue.add(bt.root);
        List<List<Integer>> results = new ArrayList<>();
        int idx = 0;

        while (!queue.isEmpty()) {

            results.add(new ArrayList<>());
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                BinaryTree.Node n = queue.poll();
                results.get(idx).add(n.val);

                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
            }

            idx++;

        }

//        for (List<Integer> result : results) {
//            System.out.println(result);
//        }
        results.forEach(System.out::println);

    }

}
