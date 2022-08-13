package com.pyz.leetcode.datastructure;

import java.util.Stack;

/**
 * @Author: peiyanzhao
 * @DateTime: 2022/8/13 11:08
 * @Description: TODO
 */
public class Day13 {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(7));
        insertIntoBST(null,5);
    }


    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null) {
            if (val == root.val) {
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;

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

    public static TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null){
            return new TreeNode(val);
        }
        TreeNode treeNode = root;
        while (treeNode != null) {
            if (val < treeNode.val && treeNode.left == null) {
                TreeNode left = new TreeNode();
                left.val = val;
                treeNode.left = left;
                break;
            } else if (val >= treeNode.val && treeNode.right == null){
                TreeNode right = new TreeNode();
                right.val = val;
                treeNode.right = right;
                break;
            }else if (treeNode.val < val){
                treeNode = treeNode.right;
            }else {
                treeNode = treeNode.left;
            }
        }

        return root;
    }


}
