Problem Link: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/description/?envType=daily-question&envId=2024-01-11

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
class MaxDiffBWNodeAndAncestor {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int minAncestor, int maxAncestor) {
        if (node == null) {
            return maxAncestor - minAncestor;
        }

        // Update min and max ancestors for the current node
        minAncestor = Math.min(minAncestor, node.val);
        maxAncestor = Math.max(maxAncestor, node.val);

        // Calculate max difference in left and right subtrees
        int leftDiff = dfs(node.left, minAncestor, maxAncestor);
        int rightDiff = dfs(node.right, minAncestor, maxAncestor);

        // Return the maximum of the differences in left, right subtrees, and the current node
        return Math.max(Math.max(leftDiff, rightDiff), maxAncestor - minAncestor);
    }
}
