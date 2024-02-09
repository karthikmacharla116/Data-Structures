Problem Link: https://leetcode.com/problems/largest-divisible-subset/?envType=daily-question&envId=2024-02-09

class LargestDivisibleSet {
    public List<Integer> largestDivisibleSubset(int[] nums) {

if (nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxSize = 1, maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    if (dp[i] > maxSize) {
                        maxSize = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int currSize = maxSize;
        int currIndex = maxIndex;

        for (int i = maxIndex; i >= 0; i--) {
            if (nums[currIndex] % nums[i] == 0 && dp[i] == currSize) {
                result.add(nums[i]);
                currSize--;
                currIndex = i;
            }
        }

        return result;

    }
}
