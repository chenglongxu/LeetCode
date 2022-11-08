package Year2022.Month08;

public class LeetCode946 {

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[pushed.length];
        int poppedCursor = 0;
        int pushedCursor = -1;
        int stackCursor = -1;
        while (poppedCursor < popped.length) {
            if (stackCursor == -1 || stack[stackCursor] != popped[poppedCursor]) {
                stackCursor++;
                pushedCursor++;
                if (pushedCursor == pushed.length) {
                    break;
                }
                stack[stackCursor] = pushed[pushedCursor];
            } else {
                stackCursor--;
                poppedCursor++;
            }
        }
        return poppedCursor == popped.length;
    }

}
