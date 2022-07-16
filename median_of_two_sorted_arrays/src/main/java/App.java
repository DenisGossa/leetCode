import java.util.Arrays;
import java.util.Collections;

public class App {
    static int[] a1 = {1, 3, 4, 5, 6, 7, 8, 3, 4, 5, 6, 7, 8};
    static int[] a2 = {2, 3, 4, 5, 6, 54, 3, 7, 4, 6, 7, 9, 67, 5, 44, 6, 7, 5, 3,};
    static int[] a3 = {1, 2};
    static int[] a4 = {3};


    public static void main(String[] args) {
        App app = new App();
        System.out.println("\n" + app.findMedianSortedArrays(a4, a3));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = mergedArrays(nums1, nums2);
        if ((merged.length % 2) == 0) {
            double d1 = merged[merged.length / 2 - 1];
            double d2 = merged[(merged.length / 2)];
            return (d1 + d2) / 2;
        }
        return merged[merged.length / 2];
    }

    private static int[] mergedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index3 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] <= nums2[index2]) {
                merged[index3++] = nums1[index1++];
            } else {
                merged[index3++] = nums2[index2++];
            }
        }
        while (index1 < nums1.length) {
            merged[index3++] = nums1[index1++];
        }
        while (index2 < nums2.length) {
            merged[index3++] = nums2[index2++];
        }
        print(merged);
        return merged;
    }

    private static void print(int[] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            System.out.print(tmp[i] + " ");
        }
    }
}
