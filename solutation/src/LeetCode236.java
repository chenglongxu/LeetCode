import java.util.HashMap;
import java.util.Map;

public class LeetCode236 {

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            Map<Integer, Boolean> findMap = new HashMap<>();
            findMap.put(p.val, false);
            findMap.put(q.val, false);
            return find(root, findMap);
        }

        private TreeNode find(TreeNode node, Map<Integer, Boolean> findMap) {
            if (node != null) {
                TreeNode result = find(node.left, findMap);
                if (result != null) {
                    return result;
                }
                result = find(node.right, findMap);
                if (result != null) {
                    return result;
                }
                if (findMap.keySet().contains(node.val)) {
                    findMap.put(node.val, true);
                }
                Boolean findAll = true;
                for (Boolean b : findMap.values()) {
                    if (b == null || !b) {
                        findAll = false;
                    }
                }
                if (findAll) {
                    return node;
                }
            }
            return null;
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
