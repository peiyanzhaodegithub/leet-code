package com.pyz.leetcode.question;

public class Demo {




    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prevHead = new ListNode(-1, new ListNode());
        ListNode prev = prevHead;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                prev.next = l2;
                l2 = l2.next;
            }else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;
        return prevHead.next;
    }

    public int lastRemaining(int n, int m) {

        int ans = 0;
        for (int i = 2; i <= n; i++){
            ans = (ans + m) % i;
        }

        return ans;
    }

    public ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;
        if (len == 0){
            return null;
        }
        if (len == 1){
            return lists[0];
        }
        ListNode listNode = mergeTwoLists(lists[0], lists[1]);

        for (int i = 2; i < lists.length; i++){
            listNode = mergeTwoLists(listNode, lists[i]);
        }

        return listNode;
    }


























}