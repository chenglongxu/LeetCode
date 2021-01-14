package Year2020;

public class LeetCode98 {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return check(root);
        }

        private boolean check(TreeNode node) {
            if (node != null) {
                if (node.left != null) {
                    if (node.left.val >= node.val) {
                        return false;
                    } else {
                        if (!check(node.left)) {
                            return false;
                        }
                    }
                }
                if (node.right != null) {
                    if (node.right.val <= node.val) {
                        return false;
                    } else {
                        if (!check(node.right)) {
                            return false;
                        }
                    }
                }
            }
            return true;
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
