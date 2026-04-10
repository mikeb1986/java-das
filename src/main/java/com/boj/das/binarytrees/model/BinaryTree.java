package com.boj.das.binarytrees.model;

public class BinaryTree {

    public Node root;

    static class Node {

        public Node(int val) {
            this.val = val;
        }

        public int val;
        public Node left;
        public Node right;
    }

    /**
     *                    1
     *                 2     3
     *              4   5  6   7
     * @return
     */
    public static BinaryTree getSampleTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        BinaryTree tree = new BinaryTree();
        tree.root = root;
        return tree;

    }

}

