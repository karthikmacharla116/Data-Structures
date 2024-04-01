Problem Link: https://leetcode.com/problems/length-of-last-word/description/?envType=daily-question&envId=2024-04-01

class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int word = 0;
        for(int ch = s.length()-1;ch>=0 ; ch--) {
            if(s.charAt(ch) != ' ')
                word++;
            else if(word != 0)
                break;
        }
        return word;
    }
}
