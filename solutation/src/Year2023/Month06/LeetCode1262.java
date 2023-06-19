package Year2023.Month06;

/**
 * https://leetcode.cn/problems/greatest-sum-divisible-by-three/
 *
 * @author xuchenglong
 */
public class LeetCode1262 {

    public static void main(String[] args) {
        System.out.println(18 == maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
        System.out.println(0 == maxSumDivThree(new int[]{4}));
        System.out.println(12 == maxSumDivThree(new int[]{1, 2, 3, 4, 4}));
    }

    public static int maxSumDivThree(int[] nums) {
        int[][] dynamics = new int[nums.length + 1][3];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (dynamics[i][j] % 3 == j) {
                    dynamics[i + 1][(j + nums[i]) % 3] = Integer.max(dynamics[i][(j + nums[i]) % 3], dynamics[i][j] + nums[i]);
                } else {
                    dynamics[i + 1][(j + nums[i]) % 3] = dynamics[i][(j + nums[i]) % 3];
                }
            }
        }
        return dynamics[nums.length][0];
    }

}
