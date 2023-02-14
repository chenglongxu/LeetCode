package Year2023.Month02;

/**
 * https://leetcode.cn/problems/longest-well-performing-interval/description/
 *
 * @author xuchenglong
 */
public class LeetCode1124 {

    public static void main(String[] args) {
        System.out.println(longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}) == 3);
        System.out.println(longestWPI(new int[]{6, 6, 6}) == 0);
        System.out.println(longestWPI(new int[]{6, 6, 9}) == 1);
        System.out.println(longestWPI(new int[]{6, 9, 9}) == 3);
        System.out.println(longestWPI(new int[]{9, 9, 9}) == 3);
    }

    public static int longestWPI(int[] hours) {
        int tiredCount = 0;
        for (int hour : hours) {
            if (hour > 8) {
                tiredCount++;
            }
        }
        if (tiredCount <= 1) {
            return tiredCount;
        }
        int[] tiredDays = new int[tiredCount];
        tiredCount = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                tiredDays[tiredCount] = i;
                tiredCount++;
            }
        }
        int maxLength = 1;
        for (int i = 0; i < tiredDays.length; i++) {
            for (int j = tiredDays.length - 1; j > i; j--) {
                if (tiredDays[j] - tiredDays[i] + 1 < 2 * (j - i + 1)) {
                    maxLength = Integer.max(maxLength, 2 * (j - i + 1) - 1);
                    break;
                }
            }
            if (2 * (tiredDays.length - i) < maxLength) {
                break;
            }
        }
        return Integer.min(maxLength, hours.length);
    }

}
