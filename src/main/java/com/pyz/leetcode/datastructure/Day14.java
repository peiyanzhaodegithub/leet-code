package com.pyz.leetcode.datastructure;

import java.util.*;

/**
 * @Author: peiyanzhao
 * @DateTime: 2022/8/14 11:48
 * @Description: TODO
 */
public class Day14 {

    public static void main(String[] args) {


    }


    public static boolean isValidBST(TreeNode root) {

        if (root == null) {
            return false;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {

            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if (root.val <= inorder){
                return false;
            }

            inorder = root.val;
            root = root.right;

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

    public boolean findTarget(TreeNode root, int k) {

        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if (set.contains(k - treeNode.val)){
                return true;
            }

            set.add(treeNode.val);
            if (treeNode.left != null){
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null){
                queue.offer(treeNode.right);
            }

        }

        return false;

    }



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;
    }

}
