Problem Link: https://leetcode.com/problems/isomorphic-strings/description/?envType=daily-question&envId=2024-04-02

class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        
        Map<Character, Character> map = new HashMap();

        for(int i=0;i<length;i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            } else {
                if(map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
