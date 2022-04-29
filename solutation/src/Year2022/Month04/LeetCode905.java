package Year2022.Month04;

public class LeetCode905 {

    public static void main(String[] args) {
        System.out.println(sortArrayByParity(new int[]{3, 1, 2, 4}));
        System.out.println(sortArrayByParity(new int[]{0}));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int[] newNums = new int[nums.length];
        int cursor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                newNums[cursor] = nums[i];
                cursor++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                newNums[cursor] = nums[i];
                cursor++;
            }
        }
        return newNums;
    }

}
