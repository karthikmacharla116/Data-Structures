Problem Link: https://leetcode.com/problems/minimum-falling-path-sum-ii/description/?envType=daily-question&envId=2024-04-26

class MinFallingPathSumII {
    int[][] dp;
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n];

        for(int[] arr: dp) {
            Arrays.fill(arr, -1);
        }

        int ans = Integer.MAX_VALUE;
        //initial row,
        for(int i=0;i<n;i++) {
            ans = Math.min(ans, grid[0][i]+solve(1,i,grid));
        }
        return ans;
    }

    int solve(int row, int notCol, int[][] grid) {
        if(row == grid.length)
            return 0;
        
        if(dp[row][notCol] != -1)
            return dp[row][notCol];
        
        int ans = Integer.MAX_VALUE;        
        for(int j=0;j<grid.length;j++) {
            if(j == notCol)
                continue;
            ans = Math.min(ans, grid[row][j] + solve(row+1, j, grid));
        }
        return dp[row][notCol] = ans;
    }
}
