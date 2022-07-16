import java.math.BigInteger;
import java.util.regex.*;

public class Solution {
    public int myAtoi(String s) {
        int negative = 1;// multiplier which value is -1 for neg numbers and 1 for positive numbers
        Matcher match;
        s = s.trim();
        //check for sign at first, save and replace and  it
        match = Pattern.compile("(-|\\+)+(\\d+)").matcher(s);
        if (match.find()) {

            if (match.group(1).equals("-")) {
                System.out.println("here");
                negative = -1;
                s = s.replaceFirst("-", "");
            } else {
                s = s.replaceFirst("\\+", "");
            }
        }
        //check for NON-DIGIT char then, if find- return
        match = Pattern.compile("(\\A[^0-9]+?)(.)*?").matcher(s);
        if (match.find()) {
            return 0;
        }
        //then check for DIGIT , if find- save it
        match = Pattern.compile("(\\A[0-9]+).*").matcher(s);
        if (match.find()) {
            s = match.group(1);

        }
        s = s.replaceAll("[^0-9]", "");
        BigInteger tmp;
        //then check for big DIGIT count , if find- save it
        try {
            tmp = new BigInteger(s).multiply(BigInteger.valueOf(negative));
            if (tmp.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) >= 0) {
                return Integer.MAX_VALUE;
            }
            if (tmp.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) <= 0) {
                return Integer.MIN_VALUE;
            }

        } catch (NumberFormatException e) {
            return 0;
        }
        return Integer.parseInt(s) * negative;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("passed test = " + sol.autoTest());
        String s4 = "-042"; //3
        System.out.println("result="+sol.myAtoi(s4));
    }

    private boolean autoTest() {
        String s1 = "4193 with words"; //4193
        String s2 = "words and 987"; //0
        String s3 = "    -042"; //-42
        String s4 = "3.14159"; //3
        String s5 = "+1"; //1
        String s6 = "-+12"; //0
        String s7 = "20000000000000000000"; // INTEGER.MAX_VALUE
        String s8 = " ++1"; //0
        String s9 = "  -0012a42";//-12
        String s10 = "+11e530408314"; //11

        try {
            assert myAtoi(s1) == 4193 : "Assertion error caught!!!!";
            assert myAtoi(s2) == 0 : "Assertion error caught!!!!";
            assert myAtoi(s3) == -42 : "Assertion error caught!!!!";
            assert myAtoi(s4) == 3 : "Assertion error caught!!!!";
            assert myAtoi(s5) == 1 : "Assertion error caught!!!!";
            assert myAtoi(s6) == 0 : "Assertion error caught!!!!";
            assert myAtoi(s7) == Integer.MAX_VALUE : "Assertion error caught!!!!";
            assert myAtoi(s8) == 0 : "Assertion error caught!!!!";
            assert myAtoi(s9) == -12 : "Assertion error caught!!!!";
            assert myAtoi(s10) == 11 : "Assertion error caught!!!!";
        } catch (AssertionError e) {
            System.out.println("TEST NOT PASSED");
            return false;
        }
        return true;
    }
}
