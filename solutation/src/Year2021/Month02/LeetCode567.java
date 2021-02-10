package Year2021.Month02;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 */
public class LeetCode567 {

    public static void main(String args[]) {
        System.out.println(Solution.checkInclusion("ab", "a"));
        System.out.println(Solution.checkInclusion("adc", "dcda"));
        System.out.println(Solution.checkInclusion("a", "ab"));
        System.out.println(Solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(Solution.checkInclusion("ab", "eidboaoo"));
    }

    static class Solution {
        public static boolean checkInclusion(String s1, String s2) {
            if (s2.length() >= s1.length()) {
                Map<String, Integer> m1 = new HashMap<>();
                for (String s : s1.split("")) {
                    m1.put(s, m1.computeIfAbsent(s, v -> 0) + 1);
                }
                String[] s2s = s2.split("");
                Map<String, Integer> m2 = new HashMap<>();
                int i = 0;
                int j = 0;
                while (j < s1.length()) {
                    m2.put(s2s[j], m2.computeIfAbsent(s2s[j], v -> 0) + 1);
                    j++;
                }
                while (j <= s2.length()) {
                    boolean equals = true;
                    for (String key : m1.keySet()) {
                        if (m2.get(key) == null || !m1.get(key).equals(m2.get(key))) {
                            equals = false;
                            break;
                        }
                    }
                    if (equals) {
                        return true;
                    } else {
                        if (j < s2.length()) {
                            m2.put(s2s[i], m2.get(s2s[i]) - 1);
                            i++;
                            m2.put(s2s[j], m2.computeIfAbsent(s2s[j], v -> 0) + 1);
                            j++;
                        } else {
                            j++;
                        }
                    }
                }
            }
            return false;
        }
    }

}
