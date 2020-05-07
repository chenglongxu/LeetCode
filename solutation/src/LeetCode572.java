import java.util.HashMap;
import java.util.Map;

public class LeetCode572 {

    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            return findAndCheck(s, t);
        }

        private boolean findAndCheck(TreeNode s, TreeNode t) {
            if (s == null) {
                return false;
            } else {
                if (s.val == t.val && check(s, t)) {
                    return true;
                }
                if (findAndCheck(s.left, t)) {
                    return true;
                }
                return findAndCheck(s.right, t);
            }
        }

        private boolean check(TreeNode s, TreeNode t) {
            if (s == null || t == null) {
                return s == t;
            }
            if (s.val != t.val) {
                return false;
            }
            if (!check(s.left, t.left)) {
                return false;
            }
            return check(s.right, t.right);
        }

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
