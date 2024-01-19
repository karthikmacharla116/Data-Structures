Problem Link: https://leetcode.com/problems/minimum-falling-path-sum/?envType=daily-question&envId=2024-01-19

class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int row = 1; row < n; row++) {
            int[] prevRow = matrix[row - 1];

            for (int col = 0; col < n; col++) {
                matrix[row][col] += Math.min(prevRow[col],
                        Math.min(prevRow[Math.max(0, col - 1)], prevRow[Math.min(n - 1, col + 1)]));
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, matrix[n - 1][col]);
        }

        return minSum;        
    }
}
