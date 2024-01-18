Problem Link: https://leetcode.com/problems/climbing-stairs/?envType=daily-question&envId=2024-01-18

class ClimbingStairs {
    public int climbStairs(int n) {
      
        if(n == 1) return 1;
        int[] dp = new int[] {1,2};
        int steps = dp[1];
        for(int i=2;i<n;i++) {
            steps = dp[0]+dp[1];
            dp[0] = dp[1];
            dp[1] = steps;
        }
        return steps;
    }
}
