package Year2022.Month08;

public class LeetCode1413 {

    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{-3, 2, -3, 4, 2}));
        System.out.println(minStartValue(new int[]{1, 2}));
        System.out.println(minStartValue(new int[]{1, -2, -3}));
    }

    public static int minStartValue(int[] nums) {
        int minValue = 0;
        int value = 0;
        for (int num : nums) {
            value += num;
            minValue = Integer.min(value, minValue);
        }
        return Integer.max(1 - minValue, 1);
    }

}
