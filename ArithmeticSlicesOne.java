Problem Link: https://leetcode.com/problems/arithmetic-slices/

class ArithmeticSlicesOne {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int total = 0;
        int[] dp = new int[n];

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                total += dp[i];
            }
        }
        return total;
    }
}
