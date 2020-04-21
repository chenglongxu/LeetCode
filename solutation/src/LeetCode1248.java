import java.util.ArrayList;
import java.util.List;

public class LeetCode1248 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }

    static class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int leftCursor = 1;
            int rightCursor = k;
            List<Integer> oddList = new ArrayList<>();
            oddList.add(-1);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 1) {
                    oddList.add(i);
                }
            }
            oddList.add(nums.length);
            if (oddList.size() - 2 < k) {
                return 0;
            } else {
                int count = 0;
                while (rightCursor < oddList.size() - 1) {
                    int preLeftCursorValue = oddList.get(leftCursor - 1);
                    int nextRightCursorValue = oddList.get(rightCursor + 1);
                    count += (oddList.get(leftCursor) - preLeftCursorValue) * (nextRightCursorValue - oddList.get(rightCursor));
                    leftCursor++;
                    rightCursor++;
                }
                return count;
            }
        }
    }

}
