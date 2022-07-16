public class NodeList {
    private final Node head = new Node();
    private int size;

    public int sise() {
        return size;
    }

    NodeList() {
    }

    NodeList(int[] array) {
        Node entryPoint = this.head;

        for (int i = 0; i < array.length; i++) {
            entryPoint.next = new Node(array[i]);
            entryPoint = entryPoint.next;
        }
        reCountSize();
    }

    public void addTail(int value) {
        Node newNode = new Node(value);
        Node entryPoint = head;
        while (entryPoint.next != null) {
            entryPoint = entryPoint.next;
        }
        entryPoint.next = newNode;
        size++;
    }

    public void addTail(int[] array) {
        if (array == null) {
            throw new NullPointerException("The first argument for addLast() is null.");
        }
        for (int i = 0; i < array.length; i++) {
            addTail(array[i]);
        }
        reCountSize();
    }

    public void addTail(final NodeList list) {
        NodeList addingTail;
        if (list == null) {
            return;
        }
        if (this == list) {
            addingTail = this.clone();
        } else {
            addingTail = list;
        }
        Node entryPoint = this.head;
        while (entryPoint.next != null) {
            entryPoint = entryPoint.next;
        }
        entryPoint.next = addingTail.head.next;
        reCountSize();
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if (head.next != null) {
            node.next = head.next;
        }
        head.next = node;
    }

    public void insert(int pos, int value) {
        int index = 0;
        if (pos >= 0 && pos <= this.sise()) {
            Node entryPoint = head;
            while (index != pos) {
                entryPoint = entryPoint.next;
                index++;
            }
            Node tmp = new Node(value);
            tmp.next = entryPoint.next;
            entryPoint.next = tmp;
        }
        size++;
    }

    public boolean delete(Node node) {
        if (node == null || node.next == null) {
            return false;
        }
        System.out.println("del note val" + node.val);
        Node entryPoint = head;
        while (entryPoint != node) {
            entryPoint = entryPoint.next;
            System.out.println(" " + entryPoint.val);
        }
        node = node.next;
        return true;
    }

    public Node findFirst(int val) {
        Node entryPoint = head;
        while (entryPoint.next != null) {
            if (entryPoint.val == val) {
                Node result = entryPoint;
                //   result.next = null;
                return result;
            }
            entryPoint = entryPoint.next;
        }
        return null;
    }

    public String toString() {
        final String DELIMITER = ",";
        Node entryPoint = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (entryPoint.next != null) {
            entryPoint = entryPoint.next;
            sb.append(entryPoint.getVal()).append(DELIMITER);
        }
        sb.setLength(sb.length() - 1);//delete last DELIMITER
        sb.append("]");
        return sb.toString();
    }

    private void reCountSize() {
        int count = 0;
        Node entryPoint = head;
        while (entryPoint.next != null) {
            entryPoint = entryPoint.next;
            count++;
        }
        this.size = count;
    }

    protected NodeList clone() {
        NodeList newList = new NodeList();
        if (this.sise() == 0) {
            return newList;
        }
        int[] tmpArray = new int[this.sise()];
        Node entryPoint = this.head;
        int index = 0;
        while (entryPoint.next != null) {
            tmpArray[index++] = entryPoint.next.getVal();
            entryPoint = entryPoint.next;
        }
        return new NodeList(tmpArray);
    }
}