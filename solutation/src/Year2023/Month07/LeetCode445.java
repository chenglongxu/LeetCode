package Year2023.Month07;

/**
 * https://leetcode.cn/problems/add-two-numbers-ii/
 *
 * @author xuchenglong
 */
public class LeetCode445 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 5;
        ListNode l11 = new ListNode();
        l11.val = 5;
        l1.next = l11;
        ListNode l2 = new ListNode();
        l2.val = 7;
        System.out.println(addTwoNumbers(l1, l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = revert(l1);
        ListNode rl2 = revert(l2);
        int carry = 0;
        ListNode listNode = new ListNode();
        while (true) {
            int addition = (rl1 != null ? rl1.val : 0) + (rl2 != null ? rl2.val : 0) + carry;
            listNode.val = addition % 10;
            carry = addition / 10;
            if (rl1 == null && rl2 == null && carry == 0) {
                return listNode.val == 0 ? listNode.next : listNode;
            }
            ListNode carryNode = new ListNode();
            carryNode.next = listNode;
            listNode = carryNode;
            if (rl1 != null) {
                rl1 = rl1.next;
            }
            if (rl2 != null) {
                rl2 = rl2.next;
            }
        }
    }

    public static ListNode revert(ListNode l1) {
        ListNode returnNode = l1;
        ListNode next = l1.next;
        l1.next = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = returnNode;
            returnNode = next;
            next = tmp;
        }
        return returnNode;
    }

    public static class ListNode {
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

}
