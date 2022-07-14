package Year2022.Month07;

import java.util.*;

public class LeetCode745 {

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple"});
        System.out.println(wordFilter.f("b", "e"));
    }

    static class WordFilter {

        Map<String, Integer> returnMap = new HashMap<>();

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                for (int j = 0; j < word.length(); j++) {
                    for (int k = 0; k < word.length(); k++) {
                        returnMap.put(word.substring(0, j + 1) + " " + word.substring(word.length() - 1 - k), i);
                    }
                }
            }
        }

        public int f(String pref, String suff) {
            Integer returnValue = returnMap.get(pref + " " + suff);
            return returnValue != null ? returnValue : -1;
        }

    }

}
