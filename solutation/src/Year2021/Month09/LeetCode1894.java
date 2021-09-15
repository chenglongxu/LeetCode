package Year2021.Month09;

public class LeetCode1894 {

    public static void main(String[] args) {
        System.out.println(chalkReplacer(new int[]{5, 1, 5}, 22));
        System.out.println(chalkReplacer(new int[]{3, 4, 1, 2}, 539095482));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        int i;
        long chalkTotal = 0;
        for (i = 0; i < chalk.length; i++) {
            chalkTotal += chalk[i];
        }
        i = 0;
        int value = (int) chalkTotal;
        if (value==chalkTotal){
            k = k % value;
        }
        while (true) {
            k -= chalk[i];
            if (k < 0) {
                break;
            }
            i++;
            if (i >= chalk.length) {
                i = 0;
            }
        }
        return i;
    }

}
