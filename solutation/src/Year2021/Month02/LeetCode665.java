package Year2021.Month02;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/non-decreasing-array/
 */
public class LeetCode665 {

    public static void main(String args[]) {
        System.out.println(Solution.checkPossibility(new int[]{5, 7, 1, 8}));
        System.out.println(Solution.checkPossibility(new int[]{1, 5, 4, 6, 7, 10, 8, 9}));
    }

    static class Solution {
        public static boolean checkPossibility(int[] nums) {
            int count = 0;
            if (nums.length > 0) {
                for (int i = 0; i < nums.length - 1; i++) {
                    if (nums[i] > nums[i + 1]) {
                        count++;
                        if (count > 1) {
                            return false;
                        } else {
                            if (i > 0) {
                                if (nums[i + 1] < nums[i - 1]) {
                                    nums[i + 1] = nums[i];
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
    }

}
