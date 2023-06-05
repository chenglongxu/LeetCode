package Year2023.Month06;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/apply-operations-to-an-array/
 *
 * @author xuchenglong
 */
public class LeetCode2460 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(applyOperations(new int[]{1, 2, 2, 1, 1, 0})));
        System.out.println(Arrays.toString(applyOperations(new int[]{0, 1})));
    }

    public static int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] << 1;
                nums[i + 1] = 0;
            }
        }
        int[] newNums = new int[nums.length];
        int cursor = 0;
        for (int num : nums) {
            if (num != 0) {
                newNums[cursor] = num;
                cursor++;
            }
        }
        return newNums;
    }

}
