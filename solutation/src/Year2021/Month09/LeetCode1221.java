package Year2021.Month09;

public class LeetCode1221 {

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
    }

    public static int balancedStringSplit(String s) {
        int count = 0;
        int rCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('R' == s.charAt(i)) {
                rCount++;
            } else {
                rCount--;
            }
            if (rCount == 0) {
                count++;
            }
        }
        return count;
    }

}
