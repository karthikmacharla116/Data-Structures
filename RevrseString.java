Problem Link: https://leetcode.com/problems/reverse-string/description/?envType=daily-question&envId=2024-06-02

class RevrseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left <= right) {
            char swap = s[left];
            s[left] = s[right];
            s[right] = swap;
            left++;
            right--;
        }
    }
}
