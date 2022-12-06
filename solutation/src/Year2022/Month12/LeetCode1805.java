package Year2022.Month12;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1805 {

    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(numDifferentIntegers("leet1234code234"));
        System.out.println(numDifferentIntegers("a1b01c001"));
        System.out.println(numDifferentIntegers("167278959591294"));
        System.out.println(numDifferentIntegers("0a0"));
    }

    public static int numDifferentIntegers(String word) {
        char[] chars = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Set<String> iSet = new HashSet<>();
        StringBuilder intString = null;
        for (int i = 0; i < word.length(); i++) {
            boolean contain = false;
            for (char aChar : chars) {
                if (word.charAt(i) == aChar) {
                    contain = true;
                    break;
                }
            }
            if (contain) {
                if (intString == null) {
                    intString = new StringBuilder(String.valueOf(word.charAt(i)));
                } else {
                    if ("0".equals(intString.toString())) {
                        intString = new StringBuilder(String.valueOf(word.charAt(i)));
                    } else {
                        intString.append(word.charAt(i));
                    }
                }
            } else {
                if (intString != null) {
                    iSet.add(intString.toString());
                    intString = null;
                }
            }
        }
        if (intString != null) {
            iSet.add(intString.toString());
        }
        return iSet.size();
    }

}
