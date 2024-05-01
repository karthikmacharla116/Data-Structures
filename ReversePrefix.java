Problem Link: https://leetcode.com/problems/reverse-prefix-of-word/description/?envType=daily-question&envId=2024-05-01

class ReversePrefix {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();

        int indexOf = word.indexOf(ch);
        sb.append(word.substring(0,indexOf+1));
        sb.reverse();
        sb.append(word.substring(indexOf+1));
        return sb.toString();
    }
}
