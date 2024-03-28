Problem Link: https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/description/?envType=daily-question&envId=2024-03-28

class MaxSubArrayWithAtMostK {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int n =  nums.length;
        int left=-1;
        int right=0;
        int ans = 0;
        while(right<n) {
            map.put(nums[right], map.getOrDefault(nums[right],0)+1);
            while(map.get(nums[right]) > k) {
                left++;
                map.put(nums[left], map.get(nums[left])-1);
            }
            ans = Math.max(ans, right-left);
            right++;
        }
        return ans;
    }
}
