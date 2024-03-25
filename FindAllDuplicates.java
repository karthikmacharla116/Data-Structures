Problem Link: https://leetcode.com/problems/find-all-duplicates-in-an-array/?envType=daily-question&envId=2024-03-25

class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {

        int index=0;
        while(index<nums.length) {
            int correct = nums[index] - 1;
            if(nums[index] != nums[correct]) {
                int swap = nums[index];
                nums[index] = nums[correct];
                nums[correct] = swap;
            } else {
                index++;
            }
        }
        List<Integer> duplicates = new ArrayList();
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != i+1)
                duplicates.add(nums[i]);
        }
        
        return duplicates;
    }
}
