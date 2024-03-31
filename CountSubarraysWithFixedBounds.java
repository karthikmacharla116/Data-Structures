Problem Link: https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/?envType=daily-question&envId=2024-03-31

class CountSubarraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minI = -1, maxI = -1, left = -1, right = 0;
        long count = 0;
        while(right < nums.length){
            if(nums[right] < minK || nums[right] > maxK){
                minI = right;
                maxI = right;
                left = right;
            }
            minI = nums[right] == minK ? right : minI;
            maxI = nums[right] == maxK ?  right : maxI;
            count += Math.min(minI, maxI) - left;
            right++;
        }
        return count;
    }
}
