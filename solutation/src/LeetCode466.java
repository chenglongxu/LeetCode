public class LeetCode466 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaxRepetitions("phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxf", 100, "xtlsgypsfa", 1));
    }

    static class Solution {
        public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
            char[] s1s = s1.toCharArray();
            char[] s2s = s2.toCharArray();
            int s2Loop = getS2Loop(s1s, s2s, n1);
            return s2Loop / n2;
        }

        private int getS2Loop(char[] s1s, char[] s2s, int n1) {
            if (n1 == 0) {
                return 0;
            }
            int s1cursor = 0;
            int s2cursor = 0;
            int firstS1Cursor = -1;
            int firstS2Cursor = -1;
            int lastLoop = -1;
            int s1Loop = 0;
            int s2Loop = 0;
            while (true) {
                while (s1s[s1cursor] != s2s[s2cursor]) {
                    s1cursor++;
                    if (s1cursor == s1s.length) {
                        s1Loop++;
                        s1cursor = 0;
                        if (s1Loop == n1) {
                            break;
                        }
                    }
                }
                if (s1Loop == n1) {
                    break;
                }
                if (firstS1Cursor == -1) {
                    firstS1Cursor = s1cursor;
                    firstS2Cursor = s2cursor;
                } else if (firstS1Cursor == s1cursor && firstS2Cursor == s2cursor) {
                    break;
                }
                s2cursor++;
                if (s2cursor == s2s.length) {
                    s2Loop++;
                    lastLoop = s1Loop;
                    s2cursor = 0;
                }
                s1cursor++;
                if (s1cursor == s1s.length) {
                    s1Loop++;
                    s1cursor = 0;
                    if (s1Loop == n1) {
                        break;
                    }
                }
            }
            int returnValue = (n1 / s1Loop) * s2Loop;
            if (lastLoop == s1Loop && n1 % s1Loop == 0) {
                return --returnValue;
            } else {
                return returnValue + getS2Loop(s1s, s2s, n1 % s1Loop);
            }
        }
    }

}
