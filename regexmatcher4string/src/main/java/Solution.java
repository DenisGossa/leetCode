import java.util.regex.*;

public class Solution {
    private static String s11 = "aa";
    private static String s12 = "a.";

    private static String s21 = "mississippi";
    private static String s22 = "mis*is*p*.";


    public boolean isMatch(String s, String p) {
        // have pattern .|*
        if(s.equals(p)){return true;}
        Pattern pattern = Pattern.compile("^mis*is*p*.$");
        StringBuilder sb = new StringBuilder().append("^").append(p).append("$");
        if (p.contains(".") || p.contains("*")) {
           // System.out.println("contains");
            Matcher matcher = Pattern.compile(sb.toString()).matcher(s);
            if (matcher.find()) {
                return true;
            }
        } else {
            System.out.println("not contains");
        }
        return false;
    }


    public boolean testIsmatch() {

        try {
            assert isMatch(s21, s22) == true;
        } catch (AssertionError error) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean testON = false;
        Solution solution = new Solution();
        if (testON) {
            System.out.println(solution.testIsmatch());
        } else {
            System.out.println(solution.isMatch(s21, s22));
        }


    }
}
