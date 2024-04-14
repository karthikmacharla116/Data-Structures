Problem Link: https://leetcode.com/problems/sum-of-left-leaves/

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
class SumOfLeftLeaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }
    
    private void dfs(TreeNode node) {
        if(node.left != null) {
            if(node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            }
            dfs(node.left);
        } 
        if(node.right != null) {
            dfs(node.right);
        }
    }
}
