/**
 * @author by.doitnow
 * written to solve a problem "Zigzag covertion" on leetcode
 */
public class Solution {
    /* for demo use fiiler-symbol line is '-'*/
    private static boolean DEMONSTRATION_ON = true; // when we want to show result at screen make it 'TRUE'

    /*when demonstrating the result, this placeholder ('-') is set for clarity
    in another case it is just '\u0000' - default value for char */
    private static char FILLER_CHAR;


    public String convert(String s, int numRows) {
        if (numRows <= 1 || s.length() == 0) {
            return s;
        }
        char[][] array = new char[numRows][s.length() / 2 + 1];
        boolean dirDown = true;//definite a direction of filling matrix: down or diagonalUp(not down)
        int index = 0;// char index at given string
        char currentChar;
        int currentRow = 0, currentColumn = 0;

        if (DEMONSTRATION_ON) { //
            FILLER_CHAR = '-';
            fillArray(array);
        } else {
            FILLER_CHAR = '\u0000';
        }

        /*we will take a character inside the loop*/
        while (true) {
            if (index >= s.length()) {
                break;
            }
            if (DEMONSTRATION_ON) {
                printArray(array);
                System.out.println();
            }

            if (dirDown) {
                if (currentRow < numRows) {
                    currentChar = s.charAt(index++);
                    array[currentRow++][currentColumn] = currentChar;
                } else {
                    dirDown = false;
                    currentRow = numRows - 2;
                    continue;
                }
            } else {
                if (currentRow >= 0) {
                    currentChar = s.charAt(index++);
                    array[currentRow--][++currentColumn] = currentChar;
                } else {
                    dirDown = true;
                    currentRow = 1;
                }
            }
        }
        System.out.println("__________________________");
        printArray(array);

        return convert(array);
    }

    public static void fillArray(char[][] tmp) {
        for (int i = 0; i < tmp.length; i++)
            for (int j = 0; j < tmp[0].length; j++) {
                tmp[i][j] = FILLER_CHAR;
            }
    }

    public static void printArray(char[][] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* convert every array's line to string deleting default filler chars*/
    private String convert(char[][] tmp) {
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                ch = tmp[i][j];
                if (ch != FILLER_CHAR) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "ABCDEFGHIJKLMNOPQRST";
        String str2 = "PAYPALISHIRING";
        String str3 = "Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.";

        final String TESTSTRING = str3;

        Solution sol = new Solution();
        String res = sol.convert(TESTSTRING, 5);
        System.out.println("Before=" + TESTSTRING.length());
        System.out.println("res len=" + res.length());
        System.out.println("res =" + res);
    }
}
