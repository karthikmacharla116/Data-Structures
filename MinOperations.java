Problem Link: https://leetcode.com/problems/minimum-number-of-operations-to-make-array-xor-equal-to-k/description/?envType=daily-question&envId=2024-04-29

class MinOperations {
    public int minOperations(int[] nums, int k) {
        int totalXOR = 0;
        for (int num : nums) {
            totalXOR ^= num;
        }
        
        int diffCount = countSetBits(totalXOR ^ k);
        return diffCount;
    }
    
    // Function to count the number of set bits in an integer
    private int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}
