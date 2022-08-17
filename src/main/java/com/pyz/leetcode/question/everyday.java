package com.pyz.leetcode.question;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class everyday {


    class MyCircularDeque {
        //循环双端队列

        private int[] ele;
        private int front, rear;
        private int capacity;


        public MyCircularDeque(int k) {
            //构造函数
            ele = new int[k + 1];
            rear = front = 0;
            capacity = k + 1;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }

            front = (front - 1 + capacity) % capacity;
            ele[front] = value;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }

            ele[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }

        public boolean deleteFront() {
            //从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            return true;
        }

        public boolean deleteLast() {
            //从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false
            if (isEmpty()) {
                return false;
            }
            rear = (rear - 1 + capacity) % capacity;
            return true;
        }

        public int getFront() {
            //从双端队列头部获得一个元素。如果双端队列为空，返回 -1
            if (isEmpty()) {
                return -1;
            }

            return ele[front];
        }

        public int getRear() {
            //获得双端队列的最后一个元素。 如果双端队列为空，返回 -1
            if (isEmpty()) {
                return -1;
            }

            return ele[(rear - 1 + capacity) % capacity];
        }

        public boolean isEmpty() {
            //若双端队列为空，则返回 true ，否则返回 false

            return front == rear;

        }

        public boolean isFull() {
            //若双端队列满了，则返回 true ，否则返回 false

            return (rear + 1) % capacity == front;
        }


    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("cbbd"));
      /*  ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers(l1, l2);*/
        //System.out.println(isPalindrome(-10));
       /* TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5)), new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8))));
        deepestLeavesSum(treeNode);*/
        //System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}));
    }

    public static boolean isPalindrome(int x) {

        String s = x + "";
        if (s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == '-') {
            return false;
        }
        String ts = "";
        if (s.length() % 2 == 0) {
            ts = s.substring(s.length() / 2);
        } else {
            ts = s.substring(s.length() / 2 + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = ts.length() - 1; i >= 0; i--) {
            sb.append(ts.charAt(i));
        }

        return Integer.parseInt(sb.toString()) == Integer.parseInt(s.substring(0, s.length() / 2));


    }

    class OrderedStream {
        // 设计有序流
        int[] index;
        String[] ele;
        int ptr;
        int max;

        public OrderedStream(int n) {
            index = new int[n + 1];
            ele = new String[n + 1];
            ptr = 1;
            max = n;
        }

        public List<String> insert(int idKey, String value) {

            List<String> list = new ArrayList<>();
            ele[idKey] = value;
            index[idKey] = idKey;
            if (ptr == idKey) {
                for (int i = ptr; i <= max; i++) {
                    if (index[i] == 0) {
                        ptr = i;
                        break;
                    }
                    list.add(ele[i]);
                }
            }

            return list;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int plus = 0;
        ListNode listNode = new ListNode();
        ListNode curr = listNode;
        while (l1 != null || l2 != null || plus > 0) {

            int v = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + plus;
            plus = v / 10;
            curr.next = new ListNode(v % 10);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            curr = curr.next;
        }

        return listNode.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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

    public static int deepestLeavesSum(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {

            int num = queue.size();
            sum = 0;
            for (int i = 1; i <= num; i++) {
                TreeNode treeNode = queue.poll();
                sum = sum + treeNode.val;
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
            }
        }

        return sum;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int p1 = 0, p2 = 0;
        int n1 = nums1.length, n2 = nums2.length;
        int[] merge = new int[n1 + n2];
        if (n1 == 0) {
            merge = nums2;
        } else if (n2 == 0) {
            merge = nums1;
        } else {
            for (int i = 0; i < (n1 + n2); i++) {
                if (p1 == n1) {
                    merge[i] = nums2[p2];
                    p2++;
                    continue;
                }
                if (p2 == n2) {
                    merge[i] = nums1[p1];
                    p1++;
                    continue;
                }
                if (nums1[p1] <= nums2[p2]) {
                    merge[i] = nums1[p1];
                    p1++;
                } else {
                    merge[i] = nums2[p2];
                    p2++;
                }
            }
        }
        int median = (n1 + n2) / 2;

        return (n1 + n2) % 2 > 0 ? merge[median] : Double.parseDouble((merge[median] + merge[median - 1]) + "") / 2;

    }

    public static String longestPalindrome(String s) {

        int len = s.length();
        if (len == 1){
            return s;
        }
        String ans = "";
        for (int i = 0; i < len; i++) {

            // 第二层循环可以改成for (int j = len - 1; j > i; j--) {}  这样判断是回文串之后就不必再往后循环了，因为这就是当前循环最长的回文串
            for (int j = i + 1; j < len; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    //判断是否是回文串
                    int p1 = i + 1, p2 = j - 1;
                    boolean is = true;
                    while (p1 <= p2) {
                        if (s.charAt(p1) != s.charAt(p2)) {
                            is = false;
                            break;
                        }
                        p1++;
                        p2--;
                    }

                    if (is && ans.length() < (j - i + 1)){
                        ans = s.substring(i,j + 1);
                    }
                }

            }
        }

        return ans.length() == 0 ? s.charAt(0)+"" : ans;

    }

    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }

        int len = s.length();
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int inc = 1;
        int line = 0;

        for (int i = 0; i < len; i++) {

            stringBuilders[line].append(s.charAt(i));
            if (line == 0){
                inc = 1;
            }

            if (line == numRows - 1){
                inc = -1;
            }

            line = line + inc;

        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < stringBuilders.length; i++) {
            res.append(stringBuilders[i]);
        }


        return res.toString();
    }


}