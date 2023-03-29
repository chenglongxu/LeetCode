package Year2023.Month03;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/count-sorted-vowel-strings/
 *
 * @author xuchenglong
 */
public class LeetCode1641 {

    public static void main(String[] args) {
        System.out.println(countVowelStrings(1));
        System.out.println(countVowelStrings(2));
    }

    public static int countVowelStrings(int n) {
        int[] vowels = new int[5];
        Arrays.fill(vowels, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                vowels[j] += vowels[j - 1];
            }
        }
        return Arrays.stream(vowels).sum();
    }

}
