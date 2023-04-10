package Year2023.Month04;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/next-greater-node-in-linked-list/
 *
 * @author xuchenglong
 */
public class LeetCode1019 {

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> returnList = new ArrayList<>();
        ListNode cursor = head;
        while (cursor != null) {
            if (cursor.next == null) {
                returnList.add(0);
                break;
            }
            ListNode nextCursor = cursor.next;
            while (true) {
                if (nextCursor.val > cursor.val) {
                    returnList.add(nextCursor.val);
                    cursor = cursor.next;
                    break;
                } else {
                    nextCursor = nextCursor.next;
                    if (nextCursor == null) {
                        returnList.add(0);
                        cursor = cursor.next;
                        break;
                    }
                }
            }
        }
        int[] ints = new int[returnList.size()];
        for (int i = 0; i < returnList.size(); i++) {
            ints[i] = returnList.get(i);
        }
        return ints;
    }

}
