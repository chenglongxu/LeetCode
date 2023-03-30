package Year2023.Month03;

/**
 * https://leetcode.cn/problems/count-substrings-that-differ-by-one-character/description/
 *
 * @author xuchenglong
 */
public class LeetCode1638 {

    public static void main(String[] args) {
        System.out.println(6 == countSubstrings("aba", "baba"));
        System.out.println(3 == countSubstrings("ab", "bb"));
        System.out.println(0 == countSubstrings("a", "a"));
        System.out.println(10 == countSubstrings("abe", "bbc"));
    }

    public static int countSubstrings(String s, String t) {
        int returnValue = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                int differ = 0;
                for (int k = 0; i + k < s.length() && j + k < t.length(); k++) {
                    if (s.charAt(i + k) != t.charAt(j + k)) {
                        differ++;
                    }
                    if (differ == 1) {
                        returnValue++;
                    }
                    if (differ > 1) {
                        break;
                    }
                }
            }
        }
        return returnValue;
    }

//    public static int countSubstrings(String s, String t) {
//        int returnValue = 0; //返回符合条件的字符总数
//        for (int i = 0; i < s.length(); i++) {  //从s字符的第一位开始递加
//            for (int j = 0; j < t.length(); j++) {  //从t字符的第一位开始递加
//                int differ = 0; //两个字符拼接的不一样的字符数量
//                for (int k = 0; i + k < s.length() && j + k < t.length(); k++) {    //位数增加
//                    if (s.charAt(i + k) != t.charAt(j + k)) {   //如果不一样，differ加1
//                        differ++;
//                    }
//                    if (differ == 1) {
//                        returnValue++;
//                    }
//                    if (differ > 1) {
//                        break;
//                    }
//                }
//            }
//        }
//        return returnValue;
//    }

}
