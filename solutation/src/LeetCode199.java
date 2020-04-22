import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode199 {

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> returnList = new ArrayList<>();
            check(root, returnList, 1);
            return returnList;
        }

        private void check(TreeNode node, List<Integer> returnList, int length) {
            if (node != null) {
                if (returnList.size() < length) {
                    returnList.add(node.val);
                }
                check(node.right, returnList, ++length);
                check(node.left, returnList, length);
            }
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

    }

}
