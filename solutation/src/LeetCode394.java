import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode394 {

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a2[c]]"));
    }

    static class Solution {
        public String decodeString(String s) {
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ']') {
                    String string = "";
                    while (!stack.peek().equals("[")) {
                        string = stack.pop() + string;
                    }
                    stack.pop();

                    String countString = "";
                    while ((!stack.isEmpty()) && (stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9')) {
                        countString = stack.pop() + countString;
                    }
                    int count = Integer.parseInt(countString);

                    String retString = "";
                    for (int j = 0; j < count; j++) {
                        retString = retString + string;
                    }
                    stack.push(retString);
                } else {
                    String str = "" + s.charAt(i);
                    stack.push(str);
                }
            }

            String aaa = "";
            while (!stack.isEmpty()) {
                aaa = stack.pop() + aaa;
            }
            return aaa;
        }
    }

}
