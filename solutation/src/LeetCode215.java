public class LeetCode215 {

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            sort(nums, 0, nums.length - 1);
            return nums[k - 1];
        }

        private void sort(int[] nums, int start, int end) {
            if (end - start > 0) {
                int first = nums[start];
                int i = start;
                int j = end;
                while (i < j) {
                    while (nums[i] > first) {
                        i++;
                    }
                    while (nums[j] < first) {
                        j--;
                    }
                    if (i < j) {
                        int value = nums[i];
                        nums[i] = nums[j];
                        nums[j] = value;
                    }
                }
                sort(nums, start, i - 1);
                sort(nums, i, end);
            }
        }
    }
}
