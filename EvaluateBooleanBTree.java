Problem Link: https://leetcode.com/problems/evaluate-boolean-binary-tree/description/?envType=daily-question&envId=2024-05-16

  DFS, Post-order traversal

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
class EvaluateBooleanBTree {
    public boolean evaluateTree(TreeNode root) {
        return postOrder(root);
    }

    boolean postOrder(TreeNode node) {
        if(node == null)
            return false;
        
        if(node.left == null && node.right == null) {
            if(node.val == 0)
                return false;
            return true;
        }

        boolean left = postOrder(node.left);
        boolean right = postOrder(node.right);

        if(node.val == 2) {
            return left || right;
        }
        return left && right;

    }
}
