Problem Link: https://leetcode.com/problems/binary-subarrays-with-sum/?envType=daily-question&envId=2024-03-14

class BinarySubArraysWithSum {
    private int slidingWindowAtMost(int[] nums, int goal) {
        int start = 0, currentSum = 0, totalCount = 0;

        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];

            while (start <= end && currentSum > goal) {
                currentSum -= nums[start++];
            }

            totalCount += end - start + 1;
        }
        return totalCount;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return slidingWindowAtMost(nums, goal) - slidingWindowAtMost(nums, goal - 1);
    }
}
