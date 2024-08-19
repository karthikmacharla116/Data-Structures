Problem Link: https://leetcode.com/problems/2-keys-keyboard/description/?envType=daily-question&envId=2024-08-19

class 2KeysKeyboard {

    int n;

    public int minSteps(int n) {
        if (n == 1) return 0;
        this.n = n;

        int[][] memo = new int[n + 1][n / 2 + 1];
        return 1 + minStepsHelper(1, 1, memo);
    }

    private int minStepsHelper(int currLen, int pasteLen, int[][] memo) {
        if (currLen == n) return 0;
        if (currLen > n) return 1000;

        // return result if it has been calculated already
        if (memo[currLen][pasteLen] != 0) return memo[currLen][pasteLen];

        int opt1 = 1 + minStepsHelper(currLen + pasteLen, pasteLen, memo);
        int opt2 = 2 + minStepsHelper(currLen * 2, currLen, memo);
        memo[currLen][pasteLen] = Math.min(opt1, opt2);
        return memo[currLen][pasteLen];
    }
}
