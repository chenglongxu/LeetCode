package Year2023.Month08;

/**
 * <a href="https://leetcode.cn/problems/minimum-jumps-to-reach-home/description/">...</a>
 */
public class LeetCode1654 {

    public static void main(String[] args) {
//        System.out.println(minimumJumps(new int[]{14, 4, 18, 1, 15}, 3, 15, 9));
//        System.out.println(minimumJumps(new int[]{8, 3, 16, 6, 12, 20}, 15, 13, 11));
//        System.out.println(minimumJumps(new int[]{1, 6, 2, 14, 5, 17, 4}, 16, 9, 7));
        System.out.println(minimumJumps(new int[]{162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98}, 29, 98, 80));
    }

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        int forbiddenMax = x;
        for (int i : forbidden) {
            forbiddenMax = Integer.max(i, forbiddenMax);
        }
        return minimumJumps(forbidden, a, b, x, 0, 0, true, forbiddenMax);
    }

    public static int minimumJumps(int[] forbidden, int a, int b, int x, int currentStep, int currentX, boolean right, int forbiddenMax) {
        if (currentX == x) {
            return currentStep;
        }
        if (currentX > forbiddenMax + b + a) {
            return -1;
        }
        if (!right && currentX > x && a > b) {
            return -1;
        }
        if (currentX < 0) {
            return -1;
        }
        for (int i : forbidden) {
            if (i == currentX) {
                return -1;
            }
        }
        int nextRight = minimumJumps(forbidden, a, b, x, currentStep + 1, currentX + a, true, forbiddenMax);
        int nextLeft = -1;
        if (right) {
            nextLeft = minimumJumps(forbidden, a, b, x, currentStep + 1, currentX - b, false, forbiddenMax);
        }
        if (nextRight > 0 && nextLeft > 0) {
            return Integer.min(nextRight, nextLeft);
        } else {
            return Integer.max(nextRight, nextLeft);
        }
    }

}
