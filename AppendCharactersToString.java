Problem Link: https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/description/?envType=daily-question&envId=2024-06-03

class AppendCharactersToString {
    public int appendCharacters(String s, String t) {
        int min = t.length();

        int maxSubSeqFound = 0;
        //iterate
        int i=0;
        int j=0;
        while(i<s.length() && j<t.length()) {
            if(s.charAt(i) == t.charAt(j)) {
                maxSubSeqFound += 1;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return min - maxSubSeqFound;
    }
}
