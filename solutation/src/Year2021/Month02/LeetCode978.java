package Year2021.Month02;

/**
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/
 */
public class LeetCode978 {

    public static void main(String args[]) {
        System.out.println(Solution.maxTurbulenceSize(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}));
        System.out.println(Solution.maxTurbulenceSize(new int[]{4, 8, 12, 16}));
        System.out.println(Solution.maxTurbulenceSize(new int[]{100}));
    }

    static class Solution {
        public static int maxTurbulenceSize(int[] arr) {
            int size = 0;
            int maxSize = 0;
            boolean up = false;
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    size = 1;
                } else if (arr[i] == arr[i - 1]) {
                    size = 1;
                } else if (up == (arr[i] > arr[i - 1])) {
                    size = 2;
                } else {
                    up = !up;
                    size++;
                }
                maxSize = Math.max(maxSize, size);
            }
            return maxSize;
        }
    }

}
