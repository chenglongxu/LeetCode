package Year2021.Month09;

import java.util.Arrays;
import java.util.List;

public class LeetCode162 {

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = nums[mid];
            int clValue = mid == 0 ? nums[0] - 1 : nums[mid - 1];
            int crValue = mid == nums.length - 1 ? nums[nums.length - 1] - 1 : nums[mid + 1];
            if (midValue > clValue && midValue > crValue) {
                return mid;
            } else if (midValue <= crValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }


}
