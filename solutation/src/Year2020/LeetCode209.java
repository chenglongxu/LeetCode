package Year2020;

public class LeetCode209 {

    public static void main(String args[]) {
        System.out.println(Solution.minSubArrayLen(5, new int[]{2, 3, 1, 1, 1, 1, 1}));
    }

    static class Solution {
        public static int minSubArrayLen(int s, int[] nums) {
            int i = 0;
            int sum = 0;
            int min = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
                while (sum >= s) {
                    min = min == 0 ? j - i + 1 : Math.min(min, j - i + 1);
                    if (sum - nums[i] >= s) {
                        sum = sum - nums[i];
                        i++;
                    } else {
                        break;
                    }
                }
            }
            return min;
        }
    }

}
