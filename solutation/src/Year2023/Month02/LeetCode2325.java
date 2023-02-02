package Year2023.Month02;

/**
 * https://leetcode.cn/problems/decode-the-message/
 *
 * @author xuchenglong
 */
public class LeetCode2325 {

    public static void main(String[] args) {
        System.out.println("this is a secret".equals(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv")));
        System.out.println("the five boxing wizards jump quickly".equals(decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb")));
    }

    public static String decodeMessage(String key, String message) {
        char[] passwordTable = new char[26];
        char[] keys = key.toCharArray();
        char currentPassword = 'a';
        for (char value : keys) {
            if (value == ' ') {
                continue;
            }
            if (passwordTable[value - 'a'] == 0) {
                passwordTable[value - 'a'] = currentPassword;
                currentPassword++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
            } else {
                sb.append(passwordTable[c - 'a']);
            }
        }
        return sb.toString();
    }

}
