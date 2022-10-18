package Year2022.Month10;

public class LeetCode902 {

    public static void main(String[] args) {
        System.out.println(atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100));    //20
        System.out.println(atMostNGivenDigitSet(new String[]{"1", "4", "9"}, 1000000000));  //29532
        System.out.println(atMostNGivenDigitSet(new String[]{"7"}, 8)); //1
        System.out.println(atMostNGivenDigitSet(new String[]{"3", "4", "8"}, 4));   //2
        System.out.println(atMostNGivenDigitSet(new String[]{"3", "4", "5", "6"}, 64)); //18
        System.out.println(atMostNGivenDigitSet(new String[]{"1"}, 834));   //3
        System.out.println(atMostNGivenDigitSet(new String[]{"1", "7"}, 231));  //10
        System.out.println(atMostNGivenDigitSet(new String[]{"1", "2", "3", "6", "7", "8"}, 211));  //79
        System.out.println(atMostNGivenDigitSet(new String[]{"1", "5", "7", "8"}, 10212));  //340
    }

    public static int atMostNGivenDigitSet(String[] digits, int n) {
        return atMostNGivenDigitSet(digits, n, true);
    }

    public static int atMostNGivenDigitSet(String[] digits, int n, boolean parent) {
        int total = 0;
        int leftValue = n;
        int level = 0;
        while (leftValue > 9) {
            leftValue = leftValue / 10;
            level++;
        }
        if (parent) {
            for (int i = 1; i <= level; i++) {
                total += Math.pow(digits.length, i);
            }
        }
        for (String digit : digits) {
            if (Integer.parseInt(digit) <= leftValue) {
                if (level == 0) {
                    total++;
                } else {
                    if (Integer.parseInt(digit) < leftValue) {
                        total += Math.pow(digits.length, level);
                    } else if (Integer.parseInt(digit) == leftValue) {
                        if (n - leftValue * Math.pow(10, level) > (level - 1 == 0 ? 0 : Math.pow(10, level - 1))) {
                            total += atMostNGivenDigitSet(digits, (int) (n - leftValue * Math.pow(10, level)), false);
                        }
                    }
                }
            }
        }
        return total;
    }

}
