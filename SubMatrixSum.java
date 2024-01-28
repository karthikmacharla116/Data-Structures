Problem Link: https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/description/?envType=daily-question&envId=2024-01-28

class SubMatrixSum {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;

        for (int top = 0; top < m; top++) {
            int[] rowSum = new int[n];

            for (int bottom = top; bottom < m; bottom++) {
                Map<Integer, Integer> sumCount = new HashMap<>();
                int runningSum = 0;

                for (int col = 0; col < n; col++) {
                    rowSum[col] += matrix[bottom][col];
                    runningSum += rowSum[col];

                    if (runningSum == target) {
                        count++;
                    }

                    if (sumCount.containsKey(runningSum - target)) {
                        count += sumCount.get(runningSum - target);
                    }

                    sumCount.put(runningSum, sumCount.getOrDefault(runningSum, 0) + 1);
                }
            }
        }

        return count;
    }
}
