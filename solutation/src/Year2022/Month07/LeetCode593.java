package Year2022.Month07;

import java.util.*;

public class LeetCode593 {

    public static void main(String[] args) {
        System.out.println(validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
        System.out.println(validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 12}));
        System.out.println(validSquare(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}));
        System.out.println(validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{0, 0}, new int[]{0, 0}));
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> lengthSet = new HashSet<>();
        lengthSet.add(getLength(p1, p2));
        lengthSet.add(getLength(p1, p3));
        lengthSet.add(getLength(p1, p4));
        lengthSet.add(getLength(p2, p3));
        lengthSet.add(getLength(p2, p4));
        lengthSet.add(getLength(p3, p4));
        return lengthSet.size() == 2 && !lengthSet.contains(0);
    }

    private static Integer getLength(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }


}
