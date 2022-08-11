package com.pyz.leetcode.datastructure;

import java.util.*;

public class Day11 {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, new TreeNode(3), null));
        isSymmetric(treeNode);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            res.add(list);
        }

        return res;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            index++;
        }

        return index;
    }

    public static boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root.left);
        q.offer(root.right);

        while (!q.isEmpty()) {

            TreeNode ltn = q.poll();
            TreeNode rtn = q.poll();

            if (ltn == null && rtn == null){
                continue;
            }
            if (ltn == null || rtn == null || ltn.val != rtn.val) {
                return false;
            }

            q.offer(ltn.left);
            q.offer(rtn.right);
            q.offer(ltn.right);
            q.offer(rtn.left);

        }

        return true;
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


}
