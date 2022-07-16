import java.util.*;

/**
 * Definition for singly-linked list.
 * public class Node {
 * int val;
 * Node next;
 * Node() {}
 * Node(int val) { this.val = val; }
 * Node(int val, Node next) { this.val = val; this.next = next; }
 * }
 */
public class App {
    private final static int[] arr1 = {0, 3, 3};
    private final static int[] arr2 = {1};
    static Boolean overFlow = false;

    protected void line2() {
        NodeList list = new NodeList();
        System.out.println("List op____________");
        list.addTail(arr1);
        System.out.println(list);
        System.out.println("size=" + list.sise());

        NodeList list2 = new NodeList();
        System.out.println("List2 op____________");
        list2.addTail(arr2);

        list2.addTail(list2);

        System.out.println(list2 + "|size=" + list2.sise());

        List<Integer> arraySum = addTwoNumbers(arr1, arr2);
        System.out.println(arraySum.toString());


    }

    /* protected static void line() {
         //NodeChainRealize.twoNodeSum(arr1, arr2);

     }*/
    public static Node addTwoNumbers(NodeChain l1, NodeChain l2) {
        List<Integer> resultList = addTwoNumbers(covertToIntArr(l1), covertToIntArr(l2));
        Node entryPoint = new Node();
        Node head = entryPoint;
        int i = 0;
        for (; i < resultList.size() - 1; i++) {
            entryPoint.val = resultList.get(i);
            entryPoint.next = new Node();
            entryPoint = entryPoint.next;
        }
        entryPoint.val = resultList.get(i);
        entryPoint.next = null;
        return head;
    }

    public static int[] covertToIntArr(NodeChain node) {
        List<Integer> list = new ArrayList<>();
        do {
            list.add(node.val);
            node = node.next;
        } while (node != null);
        //  Collections.reverse(list);
        int[] a = list.stream().mapToInt(i -> i).toArray();
        return a;
    }

    public static Node covertIntArrToListNode(int[] array) {
        Node entryPoint = new Node();
        Node head = entryPoint;
        int i = 0;
        for (; i < array.length - 1; i++) {
            entryPoint.val = array[i];
            entryPoint.next = new Node();
            entryPoint = entryPoint.next;
        }
        entryPoint.val = array[i];
        entryPoint.next = null;
        return head;
    }

    protected static void testTwosum(int[] t1, int[] t2) {
        NodeChain n1 = new NodeChain(t1);
        NodeChain n2 = new NodeChain(t2);

        Node result = addTwoNumbers(n1, n2);
        System.out.println(result);


    }

    protected static void testaddFirst() {
        NodeList n1 = new NodeList(arr1);
        n1.addFirst(5);
        n1.addFirst(4);
        n1.addFirst(2);
        n1.insert(3, 8);

        Node n2 = n1.findFirst(8);
        System.out.println(n1.delete(n2));;
        System.out.println(n1);


    }

    public static void main(String[] args) {
        testaddFirst();
    }

    public static int[] twoSum(int[] nums, int target) {
       /* int[] tmp = {2, 5, 5, 11};
        int[] res = twoSum(tmp, 10);
        System.out.println(Arrays.toString(res));*/

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if ((nums[i] + nums[j] == target) && i != j) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }


    private static List<Integer> addTwoNumbers(int[] a1, int[] a2) {
        int index1 = 0, index2 = 0;
        int curentSum;
        overFlow = false;
        List<Integer> result = new ArrayList();

        while (index1 < a1.length && index2 < a2.length) {
            curentSum = a1[index1] + a2[index2];
            if (curentSum >= 10) {
                if (!overFlow) {
                    result.add(curentSum - 10);
                } else {
                    result.add(curentSum - 10 + 1);
                }
                overFlow = true;
            } else {

                if (overFlow) {
                    int tmp = curentSum + 1;
                    if (tmp < 10) {
                        result.add(tmp);
                        overFlow = false;
                    } else {
                        result.add(0);
                        overFlow = true;
                    }
                } else {

                    result.add(curentSum);
                }
            }
            index1++;
            index2++;
        }
        System.out.println("Before=" + overFlow);
        fillList(index1, a1, result);
        System.out.println("After=" + overFlow);
        fillList(index2, a2, result);
        if (overFlow) {
            result.add(1);
        }
        return result;
    }


    private static void fillList(int index, int[] array, List<Integer> result) {

        int curentSum = 0;
        while (index < array.length) {

            curentSum = array[index];
            if (!overFlow) {
                result.add(curentSum);
            } else {
                int tmp = curentSum + 1;
                if (tmp < 10) {
                    result.add(tmp);
                    overFlow = false;
                } else {
                    result.add(0);
                }
            }
            index++;
        }
    }


}







