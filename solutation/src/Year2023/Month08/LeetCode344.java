package Year2023.Month08;

import Year2023.Month07.LeetCode445;

/**
 * https://leetcode.cn/problems/reverse-string/description/
 */
public class LeetCode344 {

    public void reverseString(char[] s) {
        char temp;
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

}
