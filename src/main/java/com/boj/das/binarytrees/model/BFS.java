package com.boj.das.binarytrees.model;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BFS {

    public static void main(String[] args) {
        BFS.bfs(BinaryTree.getSampleTree());
    }

    public static void bfs(BinaryTree bt) {

        Queue<BinaryTree.Node> queue = new LinkedBlockingQueue<>();
        queue.add(bt.root);

        while (!queue.isEmpty()) {
            BinaryTree.Node n = queue.poll();
            System.out.printf("node value %d%n", n.val);

            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }

    }

}
