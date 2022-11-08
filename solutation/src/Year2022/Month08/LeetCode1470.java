package Year2022.Month08;

import java.util.Arrays;

public class LeetCode1470 {

    public static void main(String[] args) {
        System.out.println(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3));
        System.out.println(shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4));
        System.out.println(shuffle(new int[]{1, 1, 2, 2}, 2));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] returnNums = new int[2 * n];
        for (int i = 0; i < n; i++) {
            returnNums[2 * i] = nums[i];
            returnNums[2 * i + 1] = nums[n + i];
        }
        return returnNums;
    }

}
