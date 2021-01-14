package Year2021.Month01;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1018 {

    public static void main(String args[]) {
        System.out.println(Solution.prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1}));
    }

    static class Solution {
        public static List<Boolean> prefixesDivBy5(int[] A) {
            List<Boolean> returnList = new ArrayList<>();
            int value = 0;
            for (int j : A) {
                value = (value * 2 + j) % 5;
                returnList.add(value == 0);
            }
            return returnList;
        }
    }

}
