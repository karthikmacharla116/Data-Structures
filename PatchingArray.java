Problem Link: https://leetcode.com/problems/patching-array/description/?envType=daily-question&envId=2024-06-16

class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int result = 0;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss += miss;
                result++;
            }
        }

        return result;
    }
}
