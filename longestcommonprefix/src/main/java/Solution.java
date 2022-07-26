public class Solution {
    public String longestCommonPrefix(String[] strs) {
        char tmp;
        int currentIndex = 0;
        int firstLength = strs[0].length();
        StringBuilder sb = new StringBuilder();
        try {
            while (currentIndex < firstLength) {
                tmp = strs[0].charAt(currentIndex);
                System.out.println("cur CHAR>>" + tmp);
                for (int i = 1; i < strs.length; i++) {
                    if (tmp == strs[i].charAt(currentIndex)) {
                        continue;
                    } else {
                        return sb.toString();
                    }
                }
                currentIndex++;
                sb.append(tmp);
            }
        } catch (IndexOutOfBoundsException e) {
            return sb.toString();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] t1 = {"flower", "flow", "flight"};
        Solution solution = new Solution();
        String res = solution.longestCommonPrefix(t1);

        System.out.println("res=" + res);
    }
}
