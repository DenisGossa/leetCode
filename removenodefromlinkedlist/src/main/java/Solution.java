/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev, current, todelete;
        current = head;
        todelete = head;
        int count = 1;
        while (++count <= n) {
            current = current.next;

        }
        if (current.next != null) {
            do {
                prev = todelete;
                todelete = todelete.next;
                current = current.next;
            } while (current.next != null);
            prev.next = todelete.next;

        } else {
            head = head.next;
        }
        return head;
    }


    public static void main(String[] args) {
        line2();
    }

    public static void line2() {
        int DEL_NUMBER = 4;
        ListNode listNode = new ListNode(101, new ListNode(102, new ListNode(103, new ListNode(104, null))));
        System.out.println("The index to delete element from the end of the ListNode = " + DEL_NUMBER);
        System.out.print("ListNode BEFORE >> ");
        listNode.print();

        Solution solution = new Solution();
        listNode = solution.removeNthFromEnd(listNode, DEL_NUMBER);
        System.out.print("ListNode AFTER>>");
        listNode.print();

        System.out.println("_________________________________________________________");
        DEL_NUMBER = 2;
        ListNode ln = new ListNode(1, new ListNode(2, null));
        System.out.println("The index to delete element from the end of the ListNode = " + DEL_NUMBER);
        System.out.print("ListNode BEFORE >> ");
        ln.print();
        ln = solution.removeNthFromEnd(ln, DEL_NUMBER);
        System.out.print("ListNode AFTER >> ");
        ln.print();
    }

}