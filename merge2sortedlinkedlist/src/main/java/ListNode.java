public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void add(ListNode listNode) {
        ListNode current = this;
        while (current.next != null) {
            current = current.next;

        }
        current.next = listNode;
    }

    public void add(int value) {
        ListNode current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(value);
    }

    public int size() {
        int count = 1;
        ListNode current = this;
        while (current.next != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public void print() {
        System.out.print("size=" + this.size()+":");
        ListNode current = this;
        System.out.print("[");
        while (current.next != null) {
            System.out.print(current.val + ",");
            current = current.next;
        }
        System.out.println(current.val+"]");
    }

    public static void print(ListNode ln) {
        ListNode current = ln;
        System.out.print("size=" + current.size()+":");
        System.out.print("[");
        while (current.next != null) {
            System.out.print(current.val + ",");
            current = current.next;
        }
        System.out.println(current.val+"]");
    }
}