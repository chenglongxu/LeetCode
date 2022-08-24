package Year2022.Month08;

import java.util.Arrays;

public class LeetCode1460 {

    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
        System.out.println(canBeEqual(new int[]{7}, new int[]{7}));
        System.out.println(canBeEqual(new int[]{3, 7, 9}, new int[]{3, 7, 11}));

    }

    public static boolean canBeEqual(int[] target, int[] arr) {
        target = Arrays.stream(target).sorted().toArray();
        arr = Arrays.stream(arr).sorted().toArray();
        return Arrays.equals(target, arr);
    }

}
