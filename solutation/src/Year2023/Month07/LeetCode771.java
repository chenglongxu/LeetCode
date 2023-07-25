package Year2023.Month07;

/**
 * https://leetcode.cn/problems/jewels-and-stones/
 *
 * @author xuchenglong
 */
public class LeetCode771 {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(numJewelsInStones("z", "ZZ"));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) >= 0) {
                count++;
            }
        }
        return count;
    }

}
