Problem Link: https://leetcode.com/problems/get-equal-substrings-within-budget/description/?envType=daily-question&envId=2024-05-28

class EqualSubStringWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int left = 0;
        int right = 0;

        int ans = 0;
        int currentCost = 0;
        while(right < n) {
            currentCost += Math.abs(s.charAt(right) - t.charAt(right));

            while(left < n && currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            ans = Math.max(ans, right-left+1);
            right++;
        }
        return ans;
    }
}

//Brute force - Time Limit Exceeded
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = 0;

        //traverse
        for(int a=0;a<s.length();a++) {
            int strLen = 0;
            int cost = maxCost;
            for(int i=a;i<s.length();i++) {
                int abs = Math.abs(s.charAt(i) - t.charAt(i));
                if(abs <= cost) {
                    strLen++;
                    cost -= abs;
                } else {
                    break;
                }
            }
            length = Math.max(strLen, length);
        }
        return length;
    }
}
