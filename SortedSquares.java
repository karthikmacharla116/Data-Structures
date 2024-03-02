Problem Link: https://leetcode.com/problems/squares-of-a-sorted-array/description/?envType=daily-question&envId=2024-03-02

class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        //two pointers
        int left=0;
        int right=nums.length-1;

        int[] ans = new int[right+1];
        int index = right;

        while(left <= right) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                ans[index--] = nums[left]*nums[left];
                left++;
            } else {
                ans[index--] = nums[right]*nums[right];
                right--;
            }
        }
        return ans;
    }
}

/*
        //nlogn complexity
        for(int i=0;i<nums.length;i++) {
            nums[i] = (int)Math.pow(nums[i], 2);
        }
        Arrays.sort(nums);
        return nums;
*/
