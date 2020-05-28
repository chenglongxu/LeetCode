import java.util.HashMap;
import java.util.Map;

public class LeetCode394 {

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a2[c]]"));
    }

    static class Solution {
        public String decodeString(String s) {
            if (s == null || s.length() == 0) {
                return s;
            } else {
                StringBuilder sb = new StringBuilder();
                while (s.length() > 0) {
                    int left = s.indexOf("[");
                    int num = Integer.parseInt(s.substring(0, left));


                    int right = s.indexOf("]");

                    String minS = s.substring(left + 1, right);
                    while (num > 0) {
                        sb.append(minS);
                        num--;
                    }
                    if (s.length() > right + 1) {
                        s = s.substring(right + 1);
                    } else {
                        s = "";
                    }
                }
                return sb.toString();
            }
        }
    }

}
