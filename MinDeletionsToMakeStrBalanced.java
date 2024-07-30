Problem Link: https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/?envType=daily-question&envId=2024-07-30

DP

class MinDeletionsToMakeStrBalanced {

    public int minimumDeletions(String s) {
        int n = s.length();
        int aCount = 0;

        // First pass: count the number of 'a's
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') aCount++;
        }

        int bCount = 0;
        int minDeletions = n;

        // Second pass: iterate through the string to compute minimum deletions
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') aCount--;
            minDeletions = Math.min(minDeletions, aCount + bCount);
            if (s.charAt(i) == 'b') bCount++;
        }

        return minDeletions;
    }
}
