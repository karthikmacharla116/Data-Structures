Problem Link: https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/?envType=daily-question&envId=2024-06-23

class LongestSubArray {
    public int longestSubarray(int[] nums, int limit) {
        // Deques to maintain the indices of max and min values in the window
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        
        int left = 0;
        int maxLength = 0;
        
        // Iterate through each element, expanding the window
        for (int right = 0; right < nums.length; right++) {
            // Maintain the maxDeque (for decreasing order)
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Maintain the minDeque (for increasing order)
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // Check if the current window is valid
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                // Shrink the window from the left
                if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                if (minDeque.peekFirst() == left) minDeque.pollFirst();
                left++;
            }

            // Update the maximum length of the valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }

}
