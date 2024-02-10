Problem Link: https://leetcode.com/problems/palindromic-substrings/description/?envType=daily-question&envId=2024-02-10

class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;

        for (int center = 0; center < 2 * s.length() - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}
