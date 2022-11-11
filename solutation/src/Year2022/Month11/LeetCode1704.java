package Year2022.Month11;

public class LeetCode1704 {

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
        System.out.println(!halvesAreAlike("textbook"));
    }

    public static boolean halvesAreAlike(String s) {
        boolean[] chars = new boolean[64];
        chars['a' - 'A'] = true;
        chars['e' - 'A'] = true;
        chars['i' - 'A'] = true;
        chars['o' - 'A'] = true;
        chars['u' - 'A'] = true;
        chars[0] = true;
        chars['E' - 'A'] = true;
        chars['I' - 'A'] = true;
        chars['O' - 'A'] = true;
        chars['U' - 'A'] = true;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() / 2) {
                if (chars[s.charAt(i) - 'A']) {
                    count++;
                }
            } else {
                if (chars[s.charAt(i) - 'A']) {
                    count--;
                }
            }
        }
        return count == 0;
    }

}
