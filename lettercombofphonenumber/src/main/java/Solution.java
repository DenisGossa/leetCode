import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        int stringCount=digits.length();
        List<String> result = new ArrayList<>();
        int[] values = new int[stringCount];
        for (int i = 0; i < stringCount; i++) {
            values[i] = Integer.parseInt(String.valueOf(digits.charAt(i)));
        }
        String[][] numbletter = {{""}, {""}, {"a", "b", "c"},
                {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"},
                {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"},
                {"w", "x", "y", "z"}};
        int index1, index2, index3, index4;

        switch (stringCount) {
            case 1:
                index1 = values[0];
                for (int i = 0; i < numbletter[index1].length; i++) {
                    result.add(numbletter[index1][i]);
                }
                return result;
            case 2:
                index1 = values[0];
                index2 = values[1];
                for (int i = 0; i < numbletter[index1].length; i++) {
                    for (int j = 0; j < numbletter[index2].length; j++) {
                        result.add(numbletter[index1][i].concat(numbletter[index2][j]));
                    }
                }
                return result;
            case 3:
                index1 = values[0];
                index2 = values[1];
                index3 = values[2];
                for (int i = 0; i < numbletter[index1].length; i++) {
                    for (int j = 0; j < numbletter[index2].length; j++) {
                        for (int k = 0; k < numbletter[index3].length; k++) {
                            result.add(numbletter[index1][i].concat(numbletter[index2][j]).concat(numbletter[index3][k]));
                        }
                    }
                }
                return result;
            case 4:
                index1 = values[0];
                index2 = values[1];
                index3 = values[2];
                index4 = values[3];
                for (int i = 0; i < numbletter[index1].length; i++) {
                    for (int j = 0; j < numbletter[index2].length; j++) {
                        for (int k = 0; k < numbletter[index3].length; k++) {
                            for (int l = 0; l < numbletter[index4].length; l++) {
                                result.add(numbletter[index1][i].concat(numbletter[index2][j]).concat(numbletter[index3]                                              [k]).concat(numbletter[index4][l]));}
                        }
                    }
                }
                return result;

        }
        return result;
    }

    public static void main(String[] args) {
        final String TESTSTRING = "23";
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(TESTSTRING));
    }
}
