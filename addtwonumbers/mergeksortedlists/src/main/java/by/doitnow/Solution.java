package by.doitnow;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode result = mergeTwoLists(lists[0], lists[1]);

        for (int i = 2; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);

        }
        return result;
    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode current = head;

        while (list1 != null && list2 != null) {
            if (list1.val == list2.val) {
                current.next = new ListNode(list1.val, new ListNode(list2.val));
                current = current.next.next;
                list1 = list1.next;
                list2 = list2.next;
                continue;
            } else {
                if (list1.val > list2.val) {
                    current.next = new ListNode(list2.val);
                    current = current.next;
                    list2 = list2.next;
                    continue;
                } else {
                    current.next = new ListNode(list1.val);
                    current = current.next;
                    list1 = list1.next;
                    continue;
                }
            }
        }
        while (list1 != null) {
            current.next = new ListNode(list1.val);
            current = current.next;
            list1 = list1.next;

        }
        while (list2 != null) {
            current.next = new ListNode(list2.val);
            current = current.next;
            list2 = list2.next;
        }
        return head.next;
    }



    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode l2 = new ListNode(2, new ListNode(3, new ListNode(4, null)));


        ListNode l3 = new ListNode(1, new ListNode(1, null));
        ListNode l4 = new ListNode(5, new ListNode(5, new ListNode(5, null)));


        ListNode[] tmp = new ListNode[]{l1, l2, l3, l4};

        Solution sol = new Solution();
        ListNode res = sol.mergeKLists2(tmp);
        res.print();
        //////////////////////////////////////
    }

    public ListNode mergeKLists2(ListNode[] list) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode ln : list) {
            while (ln != null) {
                pq.add(ln.val);
                ln = ln.next;

            }
        }
        if (list.length == 0) {
            return null;
        }
        ListNode head = new ListNode(pq.poll());
        ListNode current = head;
        while (pq.size() != 0) {
            current.next = new ListNode(pq.poll());
            current = current.next;

        }
        return head;
    }

}
