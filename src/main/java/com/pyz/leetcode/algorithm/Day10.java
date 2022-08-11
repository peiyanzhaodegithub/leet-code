package com.pyz.leetcode.algorithm;

import java.util.List;

public class Day10 {

    public static void main(String[] args) {

    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;

        while (list1 != null && list2 != null){

            if (list1.val > list2.val){
                prev.next = list2;
                list2 = list2.next;
            }else {
                prev.next = list1;
                list1 = list1.next;
            }

            prev = prev.next;

        }

        prev.next = list1 == null ? list2 : list1;
        return prehead.next;

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
