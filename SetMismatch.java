Problem Link: https://leetcode.com/problems/set-mismatch/?envType=daily-question&envId=2024-01-22

class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int duplicate = -1;
        int missing = -1;

        for (int i = 0; i < nums.length; i++) {
            // count sort
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                duplicate = nums[i];
                missing = i + 1;
                break;
            }
        }

        return new int[]{duplicate, missing};        
    }
}
