Problem Link: https://leetcode.com/problems/arithmetic-slices-ii-subsequence/?envType=daily-question&envId=2024-01-07

class ArthimeticSlicesTwo {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int total = 0;

        // dp[i][d] represents the count of subsequences ending at index i with common difference d
        // We use HashMap to store counts because the common difference can be negative
        List<Map<Long, Integer>> dp = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            dp.add(new HashMap<>());

            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];

                int prevCount = dp.get(j).getOrDefault(diff, 0);
                total += prevCount;  // Add the count of valid subsequences ending at index j to the total

                // Increment the count of subsequences ending at index i with common difference diff
                dp.get(i).put(diff, dp.get(i).getOrDefault(diff, 0) + prevCount + 1);
            }
        }
        System.out.println(dp);
        return total;
    }
}
