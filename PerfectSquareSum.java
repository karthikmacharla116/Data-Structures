Problem Link: https://leetcode.com/problems/perfect-squares/description/?envType=daily-question&envId=2024-02-08

public class PerfectSquareSum {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        
        return dp[n];
    }
}
