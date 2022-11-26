import java.util.Stack;
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;

                case ')':
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }

                case '}':
                    if (!stack.empty() && stack.peek() == '{') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                        break;
                    } else {
                        return false;
                    }

            }

        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "]";
        Solution sol = new Solution();
        System.out.println(sol.isValid(input));
    }
}
