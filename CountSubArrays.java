Problem Link: https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2024-03-29

class CountSubArrays {
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        List<Integer> indexesOfmaxs = new ArrayList<>();
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                indexesOfmaxs.add(i);
            }

            int freq = indexesOfmaxs.size();
            if (freq >= k) {
                ans += indexesOfmaxs.get(freq - k) + 1;
            }
        }

        return ans;
    }
}
