package Year2021.Month10;

public class LeetCode453 {

    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1, 2, 3}));
        System.out.println(minMoves(new int[]{1, 1, 1}));
    }

    public static int minMoves(int[] nums) {
        int min = 0;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                min = nums[i];
            }
            if (min > nums[i]) {
                total += (min - nums[i]) * i;
                min = nums[i];
            } else {
                total += nums[i] - min;
            }
        }
        return total;
    }

}
