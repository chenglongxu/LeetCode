package Year2020;

public class LeetCode45 {

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
    }

    static class Solution {
        public int jump(int[] nums) {
            int minStep = 0;
            if (nums.length > 1) {
                int cursor = 0;
                while (true) {
                    minStep++;
                    if (cursor + nums[cursor] >= nums.length - 1) {
                        break;
                    }
                    int nextCursor = 0;
                    int step = 0;
                    for (int i = cursor + 1; i <= cursor + nums[cursor]; i++) {
                        if (i - cursor + nums[i] > step) {
                            step = i - cursor + nums[i];
                            nextCursor = i;
                        }
                    }
                    cursor = nextCursor;
                }
            }
            return minStep;
        }
    }

}
