Problem Link: https://leetcode.com/problems/minimum-window-substring/description/?envType=daily-question&envId=2024-02-04

class MinWindowSubstring {
    public String minWindow(String s, String t) {
        int[] map = new int[123]; // Assuming ASCII character set

        for (char c : t.toCharArray()) 
            map[c]++;

        int left = 0, right = 0, count = t.length(), subLen = Integer.MAX_VALUE, start = 0;

        char[] ch = s.toCharArray();

        while (right < s.length()) {
            if (map[ch[right++]]-- > 0) 
                count--;

            while (count == 0) {
                if ((right - left) < subLen) {
                    subLen = right - (start = left);
                }
                if (map[ch[left++]]++ == 0) 
                    count++;
            }
        }

        return subLen == Integer.MAX_VALUE ? "" : s.substring(start, start + subLen);
       
    }
}
