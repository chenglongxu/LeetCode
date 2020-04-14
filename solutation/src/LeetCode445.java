import javax.management.StandardEmitterMBean;

public class LeetCode445 {

    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            l1 = reverse(l1);
            l2 = reverse(l2);
            return add(l1, l2);
        }
    }

    public static ListNode reverse(ListNode node) {
        ListNode next = node.next;
        node.next = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = node;
            node = next;
            next = tmp;
        }
        return node;
    }

    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode returnNode = null;
        boolean ten = false;
        while (l1 != null || l2 != null || ten) {
            int val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + (ten ? 1 : 0);
            if (val >= 10) {
                val = val % 10;
                ten = true;
            }else {
                ten = false;
            }
            if (returnNode == null) {
                returnNode = new ListNode(val);
            } else {
                ListNode tmp = returnNode;
                returnNode = new ListNode(val);
                returnNode.next = tmp;
            }
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (returnNode == null) {
            returnNode = new ListNode(0);
        }
        return returnNode;
    }

}
