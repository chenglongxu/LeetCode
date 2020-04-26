import java.util.ArrayList;
import java.util.List;

public class LeetCode23 {

    public static void main(String args[]) {
        Solution solution = new Solution();
        ListNode[] lists = new ListNode[2];
        lists[0] = new ListNode(0);
        lists[1] = new ListNode(1);
        solution.mergeKLists(lists);
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            List<ListNode> sortList = new ArrayList<>();
            for (ListNode node : lists) {
                add(sortList, node);
            }
            ListNode returnNode = null;
            ListNode currentNode = null;
            while (sortList.size() > 0) {
                if (currentNode == null) {
                    returnNode = sortList.get(0);
                } else {
                    currentNode.next = sortList.get(0);
                }
                currentNode = sortList.get(0);
                sortList.remove(0);
                ListNode nextNode = currentNode.next;
                add(sortList, nextNode);
            }
            return returnNode;
        }
    }

    private static void add(List<ListNode> sortList, ListNode node) {
        if (node != null) {
            if (sortList.size() == 0) {
                sortList.add(node);
            } else {
                for (int i = 0; i < sortList.size(); i++) {
                    if (node.val <= sortList.get(i).val) {
                        sortList.add(i, node);
                        break;
                    }
                    if (i + 1 == sortList.size()) {
                        sortList.add(node);
                        break;
                    }
                }
            }
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
