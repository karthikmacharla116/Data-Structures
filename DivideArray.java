ProblemLink: https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/?envType=daily-question&envId=2024-02-01

class DivideArray {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int arraySize = 3;
        int numarrays = nums.length / arraySize;

        int[][] result = new int[numarrays][arraySize];
        int arrayIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            int currentElement = nums[i];
            result[arrayIndex][i % arraySize] = currentElement;

            // Check if the current array index reaches the sub array size.
            if (i % arraySize == arraySize - 1) {
                if (currentElement - result[arrayIndex][0] > k) {
                    return new int[0][0];
                }
                arrayIndex++;
            }
        }

        return result;        
    }
}
