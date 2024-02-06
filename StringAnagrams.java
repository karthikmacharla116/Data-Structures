Problem Link: https://leetcode.com/problems/group-anagrams/description/?envType=daily-question&envId=2024-02-06

class StringAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String val = charFreq(str);
            map.computeIfAbsent(val, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String charFreq(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                sb.append((char) ('a' + i)).append(count[i]);
            }
        }
        return sb.toString();
    }
}
