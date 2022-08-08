package com.pyz.leetcode.datastructure;

import java.util.HashSet;
import java.util.Set;

public class Day8 {


    public static void main(String[] args) {

        ListNode listNode = new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,null)))));
        deleteDuplicates(listNode);

    }


    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

     /*   if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;*/

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



    public static ListNode deleteDuplicates(ListNode head) {

        Set<Integer> set = new HashSet<>();

        ListNode prev = new ListNode(0,head);

        ListNode curr = prev;

        while (curr.next != null){
            if (set.contains(curr.next.val)){
                curr.next = curr.next.next;
                continue;
            }else {
                set.add(curr.next.val);
            }

            curr = curr.next;
        }

        return prev.next;
    }

}
