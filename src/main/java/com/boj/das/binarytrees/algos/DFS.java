package com.boj.das.binarytrees.algos;

import com.boj.das.binarytrees.model.BinaryTree;

public class DFS {

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.getSampleTree();
//        DFS.preOrder(tree.root);
//        DFS.inOrder(tree.root);
        DFS.postOrder(tree.root);
    }

    /**
     * Visits n first before visiting children of n
     *
     * @param n
     */
    public static void preOrder(BinaryTree.Node n) {
        if (n == null) {
            return;
        }

        System.out.println(n.val);
        preOrder(n.left);
        preOrder(n.right);
    }

    /**
     * Visits n.left, then n, then n.right
     *
     * @param n
     */
    public static void inOrder(BinaryTree.Node n) {
        if (n == null) {
            return;
        }

        inOrder(n.left);
        System.out.println(n.val);
        inOrder(n.right);

    }

    /**
     * Visits children of n, then n
     *
     * @param n
     */
    public static void postOrder(BinaryTree.Node n) {
        if (n == null) {
            return;
        }

        postOrder(n.left);
        postOrder(n.right);
        System.out.println(n.val);

    }

}
