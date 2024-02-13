Problem Link: https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/?envType=daily-question&envId=2024-02-13

class FirstPalindromString {
    public String firstPalindrome(String[] words) {
        
        for(String str: words) {
            if(isPalindrome(str, 0, str.length()-1))
                return str;
        }
        return "";
    }
    //Recursion
    boolean isPalindrome(String str, int start, int end) {
        if(start>end)
            return true;
        
        if(str.charAt(start) != str.charAt(end))
            return false;
        return isPalindrome(str, start+1, end-1);
    }
}
