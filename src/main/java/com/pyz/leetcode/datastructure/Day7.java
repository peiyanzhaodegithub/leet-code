package com.pyz.leetcode.datastructure;

import org.yaml.snakeyaml.events.Event;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: peiyanzhao
 * @DateTime: 2022/8/7 12:30
 * @Description: TODO
 */
public class Day7 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null)))))));
        removeElements(listNode, 6);
    }


   /* public static boolean hasCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        ListNode listNode = head;
        while (listNode != null){
            if (!set.add(listNode)){
                return true;
            }
            listNode = listNode.next;
        }
        return false;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }*/

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode prehead = new ListNode(-1, new ListNode());
        ListNode prev = prehead;
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
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


    public static ListNode removeElements(ListNode head, int val) {

        ListNode dummtHead = new ListNode(0, head);
        ListNode temp = dummtHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return dummtHead.next;
    }

}
