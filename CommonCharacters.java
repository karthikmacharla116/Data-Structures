Problem Link: https://leetcode.com/problems/find-common-characters/description/?envType=daily-question&envId=2024-06-05

//Optimized
class CommonCharacters {
    public List<String> commonChars(String[] words) {
        
        int[] common = new int[26];
        Arrays.fill(common, Integer.MAX_VALUE);
        for(String word: words){
            int[] cnt = new int[26];
            for(char c:word.toCharArray()){
                cnt[c-'a']++;
            }
            for(int i=0;i<26;i++){
                common[i] = Math.min(common[i], cnt[i]);
            }
        }
        List<String> ans = new ArrayList();
        for(int i=0;i<26;i++){
            for(int j=0;j<common[i];j++){
                ans.add(""+(char)('a'+i));
            }
        }
        return ans;

    }
}

//Brute
class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        Map<Character, Integer> freq = new HashMap();

        String str1 = words[0];
        for(int i=0;i<str1.length();i++) {
            Character ch = str1.charAt(i);
            freq.put(ch, freq.getOrDefault(ch,0)+1);            
        }

        for(int i=1;i<n;i++) {
            Map<Character, Integer> map = new HashMap();
            for(int j=0;j<words[i].length();j++) {
                Character ch = words[i].charAt(j);
                map.put(ch, map.getOrDefault(ch,0)+1);
                }

            //compare the map with freq
            for(Map.Entry<Character, Integer> e: freq.entrySet()) {
                if(map.containsKey(e.getKey())) {
                    e.setValue(Math.min(e.getValue(), map.get(e.getKey())));
                } else {
                    e.setValue(0);
                }
            }
        }
        List<String> res = new ArrayList();
        for(Map.Entry<Character, Integer> e: freq.entrySet()) {
            if(e.getValue() > 0) {
                for(int i=0;i<e.getValue();i++)
                    res.add(String.valueOf(e.getKey()));
            }
        }
        return res;
    }
}
