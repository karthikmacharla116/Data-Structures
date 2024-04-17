Problem Link: https://leetcode.com/problems/smallest-string-starting-from-leaf/

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
class SmallestStringFromLeaf {
    String result;
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }
    
    private String dfs(TreeNode node, String suffix) {
        if (node == null) return suffix;
        
        // Convert the current node's value to a character
        char c = (char)('a' + node.val);
        
        // Update the suffix with the character
        String newSuffix = c + suffix;
        
        // If the current node is a leaf, return the suffix
        if (node.left == null && node.right == null) {
            return newSuffix;
        }
        
        // Otherwise, continue DFS traversal
        String left = node.left != null ? dfs(node.left, newSuffix) : null;
        String right = node.right != null ? dfs(node.right, newSuffix) : null;
        
        // Return the lexicographically smallest string from the left and right subtrees
        if (left == null) return right;
        if (right == null) return left;
        return left.compareTo(right) <= 0 ? left : right;
    }
}  
