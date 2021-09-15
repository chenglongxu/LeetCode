package Year2021.Month09;

import java.util.*;

public class LeetCode524 {

    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
        System.out.println(findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((word1, word2) -> {
            if (word1.length() != word2.length()) {
                return word2.length() - word1.length();
            } else {
                return word1.compareTo(word2);
            }
        });
        String returnValue = "";
        for (String value : dictionary) {
            if ("".equals(returnValue)) {
                returnValue = getReturnValue(s, value, returnValue);
            }
        }
        return returnValue;
    }

    private static String getReturnValue(String s, String v, String returnValue) {
        int i = 0;
        int y = 0;
        while (y < v.length() && i < s.length()) {
            if (s.charAt(i) == v.charAt(y)) {
                y++;
            }
            i++;
        }
        if (y == v.length()) {
            return v;
        }
        return returnValue;
    }

}
