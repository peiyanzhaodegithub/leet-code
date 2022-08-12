package com.pyz.leetcode.datastructure;

import java.util.Stack;

public class Day12 {


    public static void main(String[] args) {

    }


    public TreeNode invertTree(TreeNode root) {

        if (root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            TreeNode temp = treeNode.left;
            treeNode.left = treeNode.right;
            treeNode.right = temp;
            if (treeNode.right != null){
                stack.push(treeNode.right);
            }
            if (treeNode.left != null){
                stack.push(treeNode.left);
            }
        }

        return root;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null){
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){

            TreeNode treeNode = stack.pop();
            if (treeNode.val == targetSum && treeNode.left == null && treeNode.right == null){
                return true;
            }
            if (treeNode.right != null){
                treeNode.right.val = treeNode.val + treeNode.right.val;
                stack.push(treeNode.right);
            }

            if (treeNode.left != null){
                treeNode.left.val = treeNode.val + treeNode.left.val;
                stack.push(treeNode.left);
            }
        }

        return false;

    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
