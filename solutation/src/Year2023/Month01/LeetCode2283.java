package Year2023.Month01;

/**
 * https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value/submissions/394636757/
 */
public class LeetCode2283 {

    public static void main(String[] args) {
        System.out.println(digitCount("1210"));
        System.out.println(digitCount("030"));
    }

    public static boolean digitCount(String num) {
        int[] nums = new int[10];
        char[] ss = num.toCharArray();
        for (char c : ss) {
            nums[c - '0'] = nums[c - '0'] + 1;
        }
        for (int i = 0; i < ss.length; i++) {
            if (nums[i] != ss[i] - '0') {
                return false;
            }
        }
        return true;
    }

}
