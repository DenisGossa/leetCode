class LongestPalindrome {
    private static int[] d1; // for odd
    private static int[] d2; // for even
    private int index = -1;
    private boolean d1Warkable;

    public String longestPalindrome(String s) {
        findPalindrome(s);
        String result;

        int[] tmp1 = findMaxValuePosition(d1);//get [maxValue,indexOfMaxValue] from d1[]
        int[] tmp2 = findMaxValuePosition(d2);//get [maxValue,indexOfMaxValue] from d2[]

        d1Warkable = tmp1[0] > tmp2[0] ? true : false; // define one working array: d1 or d2

        if (d1Warkable) {
            index = tmp1[1];
            int low = index - d1[index] + 1;
            int hi = d1[index] + index;
            result = s.substring(low, hi);

        } else {
            index = tmp2[1];
            int low = index - d2[index];
            int hi = low + d2[index] * 2;
            result = s.substring(low, hi);

        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "asdasdsadsa";
        String s2 = "babad";
        String s3 = "notontmagamagam";
        String s4 = "cbbd";
        String s = s4;

        System.out.println("Str lentgh=" + s.length());
        LongestPalindrome lp = new LongestPalindrome();
        s = lp.longestPalindrome(s);
        printArray(d1);
        System.out.println();
        printArray(d2);
        System.out.println("\nLongest>>" + s);
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private int[] findMaxValuePosition(int[] a) {
        int tmp = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > tmp) {
                index = i;
                tmp = a[i];
            }
        }
        return new int[]{tmp, index};
    }

    private static void findPalindrome(String s) {
        //1st - odd length algorithm:
        int i;
        int n = s.length();
        d1 = new int[n];
        int l = 0;
        int r = -1;
        int k;

        for (i = 0; i < n; i++) {
            if (i > r) {
                k = 1;
            } else {
                k = (d1[l + r - i] < r - i) ? d1[l + r - i] : r - i;
            }

            while (0 <= i - k && i + k < n && s.charAt(i - k) == s.charAt(i + k)) {
                k++;
            }
            d1[i] = k;
            if (i + k - 1 > r)
                r = i + k - 1;
            l = i - k + 1;
        }
        //2nd - even length algorithm:
        d2 = new int[n];
        l = 0;
        r = -1;

        for (i = 0; i < n; i++) {
            if (i > r) {
                k = 0;
            } else {
                k = (d2[l + r - i + 1] < r - i + 1) ? d2[l + r - i + 1] : r - i + 1;
            }

            while (i + k < n && i - k - 1 >= 0 && s.charAt(i + k) == s.charAt(i - k - 1)) {
                k++;
            }
            d2[i] = k;

            if (i + k - 1 > r) {
                l = i - k;
                r = i + k - 1;
            }
        }
    }
}