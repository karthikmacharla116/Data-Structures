Problem Link: https://leetcode.com/problems/determine-if-string-halves-are-alike/description/?envType=daily-question&envId=2024-01-12

class StringsAlike {
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        String a = s.substring(0, mid).toUpperCase();;
        String b = s.substring(mid).toUpperCase();
        
        int countFirst = vowels(a);
        int countSecond = vowels(b);
        
        return vowels(a) == vowels(b);
    }
    
    private int vowels(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if ("AEIOU".indexOf(ch) != -1)
                count++;
        }
        return count;
    }
}
