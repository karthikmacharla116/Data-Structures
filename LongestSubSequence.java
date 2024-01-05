Problem Link: https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=daily-question&envId=2024-01-05

class LongestSubSequence {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];

        for(int i=1;i<length;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j]) {
                    if(dp[j]+1 > dp[i])
                        dp[i] = dp[j]+1;
                }
            }
        }
        
        int maxIndex = 0;
        for(int i=0;i<length;i++) {
            if(dp[i] > dp[maxIndex])
                maxIndex = i;
        }
        return dp[maxIndex]+1;
    }
}
