public class NodeChain {
    int val;
    NodeChain next = null;

    public NodeChain() {
    }

    public NodeChain(int val) {
        this.val = val;
    }

    public NodeChain(int[] array) {
        NodeChain entryPoint = this;
        int i = 0;
        for (; i < array.length - 1; i++) {
            entryPoint.val = array[i];
            entryPoint.next = new NodeChain();
            entryPoint = entryPoint.next;
        }
        entryPoint.val = array[i];
        entryPoint.next = null;

    }

    public NodeChain(int val, NodeChain next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        final String DELIMITER=",";
        StringBuilder sb = new StringBuilder();
        NodeChain entryPoint = this;
        do {
            sb.append(entryPoint.val).append(DELIMITER);
            entryPoint = entryPoint.next;
        } while (entryPoint != null);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public NodeChain addFirst(int val){
        NodeChain node=new NodeChain(val);
        node.next=this;
        return node;
    }

}
