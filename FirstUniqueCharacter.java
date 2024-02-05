Problem Link: https://leetcode.com/problems/first-unique-character-in-a-string/description/?envType=daily-question&envId=2024-02-05

class FirstUniqueCharacter {
    public int firstUniqChar(String s) {

        int unique = Integer.MAX_VALUE;

        for(char c='a'; c<='z';c++) {
            int index = s.indexOf(c);
            if(index != -1 && index == s.lastIndexOf(c)) 
                unique = Math.min(unique, index);
        }
        return unique == Integer.MAX_VALUE ? -1: unique;
    }
}
