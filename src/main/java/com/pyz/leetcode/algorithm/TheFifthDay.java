package com.pyz.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class TheFifthDay {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));

        System.out.println(removeNthFromEnd(listNode, 2));

    }


    public static ListNode middleNode(ListNode head) {

        int index = 0;
        ListNode curr = head;
        while (curr.next != null) {
            index++;
            curr = curr.next;
        }

        int p = index % 2 == 0 ? index / 2 : index / 2 + 1;

        curr = head;
        index = 0;
        while (curr.next != null) {
            index++;
            curr = curr.next;
            if (index == p) {
                break;
            }
        }

        return curr;

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


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode listNode = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = listNode;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        ListNode ans = listNode.next;

        return ans;
    }

}








