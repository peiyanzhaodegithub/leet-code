package com.pyz.leetcode.question;

import java.util.ArrayList;
import java.util.List;

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

        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        addTwoNumbers(l1,l2);
        //System.out.println(isPalindrome(-10));
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
        while (l1 != null || l2 != null ||  plus > 0) {

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


}