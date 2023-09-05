package Year2023.Month09;

/**
 * <a href="https://leetcode.cn/problems/minimum-jumps-to-reach-home/description/">...</a>
 */
public class LeetCode2605 {

    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{4, 1, 3}, new int[]{5, 7}));
        System.out.println(minNumber(new int[]{3, 5, 2, 6}, new int[]{3, 1, 7}));
    }

    public static int minNumber(int[] nums1, int[] nums2) {
        int min = 10;
        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) {
                    min = Integer.min(min, i);
                }
            }
        }
        if (min < 10) {
            return min;
        }
        int min1 = 9;
        for (int i : nums1) {
            min1 = Integer.min(min1, i);
        }
        int min2 = 9;
        for (int i : nums2) {
            min2 = Integer.min(min2, i);
        }
        return Integer.min(min1, min2) * 10 + Integer.max(min1, min2);
    }

}
