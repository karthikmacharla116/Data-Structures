Problem Link: https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/?envType=daily-question&envId=2024-05-02

class FindMaxK {
    public int findMaxK(int[] nums) {
        int highest = -1;
        Set<Integer> set =  new HashSet();
        for(int num: nums) 
            set.add(num);
        
        for(int i=0;i<nums.length;i++) {
            if(set.contains(-1*nums[i]) && nums[i] > highest)
                highest = nums[i];
        }
        
        return highest;
    }
}
