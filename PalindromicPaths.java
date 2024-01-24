Problem Link: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/?envType=daily-question&envId=2024-01-24

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
class PalindromicPaths {
    public int pseudoPalindromicPaths(TreeNode root) {
        return backtrack(root, new int[10]);
    }

    private int backtrack(TreeNode node, int[] freq) {
        if (node == null) {
            return 0;
        }

        // Toggle the frequency of the current digit
        freq[node.val]++;

        // If it's a leaf node, check for pseudo-palindromic path
        if (node.left == null && node.right == null) {
            int oddCount = 0;
            for (int f : freq) {
                if (f % 2 == 1) {
                    oddCount++;
                }
            }
            // Undo the changes before returning
            freq[node.val]--;
            return (oddCount <= 1) ? 1 : 0;
        }

        // Recursively traverse the left and right subtrees
        int result = backtrack(node.left, freq) + backtrack(node.right, freq);

        // Undo the changes before returning
        freq[node.val]--;

        return result;
    }
}
