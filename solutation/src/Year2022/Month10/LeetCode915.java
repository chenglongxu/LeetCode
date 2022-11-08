package Year2022.Month10;

public class LeetCode915 {

    public static void main(String[] args) {
        System.out.println(partitionDisjoint(new int[]{5, 0, 3, 8, 6}) == 3);
        System.out.println(partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12}) == 4);
    }

    public static int partitionDisjoint(int[] nums) {
        int[][] map = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                map[i][0] = nums[i];
                map[nums.length - 1 - i][1] = 10000000;
            } else {
                map[i][0] = Integer.max(nums[i], map[i - 1][0]);
                map[nums.length - 1 - i][1] = Integer.min(nums[nums.length - i], map[nums.length - i][1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map[i][0] <= map[i][1]) {
                return i + 1;
            }
        }
        return nums.length;
    }

}
