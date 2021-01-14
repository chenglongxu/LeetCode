package Year2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            view(root, 0, map);
            return new ArrayList<>(map.values());
        }

        private void view(TreeNode node, int level, Map<Integer, List<Integer>> map) {
            if (node != null) {
                List<Integer> list = map.computeIfAbsent(level, v -> new ArrayList<>());
                list.add(node.val);
                view(node.left, ++level, map);
                view(node.right, level, map);
            }
        }

    }

}
