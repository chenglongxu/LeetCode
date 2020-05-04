import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode3 {

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int length = 0;
            if (s != null && s.length() > 0) {
                char[] chars = s.toCharArray();
                Map<Integer, String> sMap = new HashMap<>();
                for (int i = 0; i < chars.length; i++) {
                    for (int j = 0; j <= i; j++) {
                        String jStr = sMap.get(j);
                        if (jStr == null) {
                            if (j == i) {
                                jStr = "" + chars[i];
                                sMap.put(i, jStr);
                                if (jStr.length() > length) {
                                    length = jStr.length();
                                }
                            }
                        } else {
                            if (jStr.contains("" + chars[i])) {
                                sMap.put(j, null);
                            } else {
                                jStr += chars[i];
                                sMap.put(j, jStr);
                                if (jStr.length() > length) {
                                    length = jStr.length();
                                }
                            }
                        }
                    }
                }
            }
            return length;
        }
    }

}
