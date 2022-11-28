import java.util.List;

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
            current=current.next;
            list1 = list1.next;

        }
        while (list2 != null) {
            current.next = new ListNode(list2.val);
            current=current.next;
            list2 = list2.next;
        }
        return head.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode m = new Solution().mergeTwoLists(l1, l2);
        m.print();

    }
}
