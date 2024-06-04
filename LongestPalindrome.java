Problem Link: https://leetcode.com/problems/longest-palindrome/description/?envType=daily-question&envId=2024-06-04

class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freqMap = new HashMap();

        for(int i=0;i<s.length();i++) 
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0)+1);
        
        int longest = 0;
        boolean isOdd = false;
        for(Map.Entry<Character,Integer> e: freqMap.entrySet()) {
            if(e.getValue() % 2 == 0) {
                longest += e.getValue();
            } else {
                longest += e.getValue() -1;
                isOdd = true;
            }
        }
        return isOdd?longest+1:longest;
    }
}
