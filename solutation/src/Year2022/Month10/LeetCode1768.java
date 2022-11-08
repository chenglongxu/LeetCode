package Year2022.Month10;

public class LeetCode1768 {

    public static void main(String[] args) {
        System.out.println("apbqcr".equals(mergeAlternately("abc", "pqr")));
        System.out.println("apbqrs".equals(mergeAlternately("ab", "pqrs")));
        System.out.println("apbqcd".equals(mergeAlternately("abcd", "pq")));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        String[] s1 = word1.split("");
        String[] s2 = word2.split("");
        for (int i = 0; i < Integer.max(s1.length, s2.length); i++) {
            if (s1.length > i) {
                sb.append(s1[i]);
            }
            if (s2.length > i) {
                sb.append(s2[i]);
            }
        }
        return sb.toString();
    }

}
