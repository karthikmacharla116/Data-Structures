Problem Link: https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/?envType=daily-question&envId=2024-01-02

class ArrayToTwoDArray {
    public List<List<Integer>> findMatrix(int[] nums) {
        int dp[] = new int[nums.length + 1];

        List<List<Integer>> result = new ArrayList<>();
        for (int num : nums) {
            if (dp[num] >= result.size()) {
                result.add(new ArrayList<>());
            }

            result.get(dp[num]).add(num);
            dp[num]++;
        }
        return result;
    }
}
