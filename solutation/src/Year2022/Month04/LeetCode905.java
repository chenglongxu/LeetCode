package Year2022.Month04;

public class LeetCode905 {

    public static void main(String[] args) {
        System.out.println(sortArrayByParity(new int[]{3, 1, 2, 4}));
        System.out.println(sortArrayByParity(new int[]{0}));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int[] newNums = new int[nums.length];
        int cursor = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                newNums[cursor] = num;
                cursor++;
            }
        }
        for (int num : nums) {
            if (num % 2 == 1) {
                newNums[cursor] = num;
                cursor++;
            }
        }
        return newNums;
    }

}
