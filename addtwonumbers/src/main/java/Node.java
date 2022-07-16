public class Node {
    int val;
    Node next = null;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
    public int getVal() {
        return val;
    }
    public void setVal(int value) {
        val =value;
    }

    public String toString() {
        final String DELIMITER=",";
        StringBuilder sb = new StringBuilder();
        Node entryPoint = this;
        do {
            sb.append(entryPoint.val).append(DELIMITER);
            entryPoint = entryPoint.next;
        } while (entryPoint != null);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}