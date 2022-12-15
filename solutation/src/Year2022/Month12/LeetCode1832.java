package Year2022.Month12;

/**
 * https://leetcode.cn/problems/check-if-the-sentence-is-pangram/
 *
 * @author xuchenglong
 */
public class LeetCode1832 {

    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("leetcode"));
    }

    public static boolean checkIfPangram(String sentence) {
        int[] ints = new int[26];
        for (byte aByte : sentence.getBytes()) {
            ints[aByte - 'a'] = 1;
        }
        for (int anInt : ints) {
            if (anInt == 0) {
                return false;
            }
        }
        return true;
    }

}
