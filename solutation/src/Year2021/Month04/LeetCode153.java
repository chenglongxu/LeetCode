package Year2021.Month04;

public class LeetCode153 {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{11, 13, 15, 17}));
        System.out.println(findMin(new int[]{2, 1}));
    }

    public static int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        } else {
            int start = 0;
            int end = nums.length - 1;
            int cursor;
            while (true) {
                cursor = start + (end - start + 1) / 2;
                if (nums[cursor] > nums[0]) {
                    start = cursor + 1;
                } else {
                    if (nums[cursor - 1] > nums[cursor]) {
                        break;
                    } else {
                        end = cursor - 1;
                    }
                }
            }
            return nums[cursor];
        }
    }

}
