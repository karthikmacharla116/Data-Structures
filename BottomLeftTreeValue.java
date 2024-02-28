Problem Link: https://leetcode.com/problems/find-bottom-left-tree-value/?envType=daily-question&envId=2024-02-28

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1; // Handle empty tree
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int leftmostValue = -1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                if (i == 0) {
                    // Update leftmostValue only for the first node in each level
                    leftmostValue = current.val;
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }

            }
        }

        return leftmostValue;
    }
}
