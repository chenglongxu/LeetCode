package Year2022.Month06;

public class LeetCode513 {

    public static void main(String[] args) {
        System.out.println(findLUSlength(new String[]{"aba", "cdc", "eae"}));
        System.out.println(findLUSlength(new String[]{"aaa", "aaa", "aa"}));
        System.out.println(findLUSlength(new String[]{"aabbcc", "aabbcc", "cb"}));
    }

    public static int findLUSlength(String[] strs) {
        int returnValue = -1;
        for (int i = 0; i < strs.length; i++) {
            String iValue = strs[i];
            if (iValue.length() > returnValue) {
                boolean contain = false;
                for (int j = 0; j < strs.length; j++) {
                    if (j == i) {
                        continue;
                    }
                    String jValue = strs[j];
                    if (iValue.length() <= jValue.length()) {
                        int cursorJ = 0;
                        String[] iValues = iValue.split("");
                        for (String value : iValues) {
                            cursorJ = jValue.indexOf(value, cursorJ);
                            if (cursorJ == -1) {
                                break;
                            } else {
                                cursorJ++;
                            }
                        }
                        if (cursorJ != -1) {
                            contain = true;
                            break;
                        }
                    }
                }
                if (!contain) {
                    returnValue = iValue.length();
                }
            }
        }
        return returnValue;
    }

}
