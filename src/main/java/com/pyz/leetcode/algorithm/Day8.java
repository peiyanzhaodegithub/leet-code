package com.pyz.leetcode.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day8 {


    public static void main(String[] args) {

       /* TreeNode treeNode1 = new TreeNode(1,new TreeNode(3,new TreeNode(5),null),new TreeNode(2));
        TreeNode treeNode2 = new TreeNode(2,new TreeNode(1,null,new TreeNode(4)),new TreeNode(3,null,new TreeNode(7)));*/
        Node node = new Node(1, new Node(2, new Node(4, new Node(8), new Node(9), null), new Node(5, new Node(10), new Node(11), null), null), new Node(3, new Node(6, new Node(12), new Node(13), null), new Node(7, new Node(14), new Node(15), null), null), null);
        Node node1 = connect(node);
        System.out.println(node1);
    }

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;

        /*if (root1 == null){
            return root2;
        }
        if (root2 == null){
            return root1;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(root1);
        queue2.offer(root2);

        while (!queue1.isEmpty()) {
            TreeNode treeNode1 = queue1.poll();
            TreeNode treeNode2 = queue2.poll();
            treeNode1.val = treeNode1.val + treeNode2.val;
            if (treeNode1.left != null || treeNode2.left != null){
                if (treeNode1.left != null){
                    queue1.offer(treeNode1.left);
                }else {
                    TreeNode treeNode = new TreeNode(0,null,null);
                    treeNode1.left = treeNode;
                    queue1.offer(treeNode);
                }
                if (treeNode2.left != null){
                    queue2.offer(treeNode2.left);
                }else {
                    TreeNode treeNode = new TreeNode(0,null,null);
                    treeNode2.left = treeNode;
                    queue2.offer(treeNode);
                }
            }

            if (treeNode1.right != null || treeNode2.right != null){
                if (treeNode1.right != null){
                    queue1.offer(treeNode1.right);
                }else {
                    TreeNode treeNode = new TreeNode(0,null,null);
                    treeNode1.right = treeNode;
                    queue1.offer(treeNode);
                }
                if (treeNode2.right != null){
                    queue2.offer(treeNode2.right);
                }else {
                    TreeNode treeNode = new TreeNode(0,null,null);
                    treeNode2.right = treeNode;
                    queue2.offer(treeNode);
                }
            }
        }

        return root1;*/

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static Node connect(Node root) {

        if (root == null || root.left == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();

        root.left.next = root.right;

        if (root.left.left != null) {
            queue.offer(root.left);
            queue.offer(root.right);
        }

        Queue<Node> list = new LinkedList<>();

        while (!queue.isEmpty()) {
            Node t = queue.poll();
            if (!queue.isEmpty()) {
                Node p = queue.peek();
                t.left.next = t.right;
                t.right.next = p.left;
            }else {
                t.left.next = t.right;
            }

            list.offer(t);
            if (queue.isEmpty() && t.right.right != null) {
                while (!list.isEmpty()) {
                    Node node = list.poll();
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
