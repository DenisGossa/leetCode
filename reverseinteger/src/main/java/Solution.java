/**
 * @author by.doitnow
 * written to solve a problem "Reverse Integer" on leetcode
 */
public class Solution {
    public int reverse(int x) {
        boolean negative;
        if (x < 0) {
            negative = true;
            x *= -1;
        } else {
            negative = false;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        sb.reverse();
        try {
            x = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }

        if (negative) {
            return -x;
        }
        return x;
    }

    public static void main(String[] args) {
        int x1 = 1534236469;
        int x2 = -240;
        final int INPUT = x1;
        Solution sol = new Solution();
        int i = sol.reverse(INPUT);
        System.out.println(i);
    }
}
