Problem Link: https://leetcode.com/problems/sort-characters-by-frequency/description/?envType=daily-question&envId=2024-02-07

class CharacterFrequency {
    public String frequencySort(String s) {
        char[] str = s.toCharArray();
        int[] freq = new int[128];
        
        // Count the frequency of each character in the input string
        for (int i = 0; i < str.length; i++) {
            freq[str[i]]++;
        }

        // Reconstruct the string based on frequencies in descending order
        for (int i = 0; i < str.length;) {
            char cHigh = ',';
            
            // Find the character with the maximum frequency
            for (int j = 0; j < 128; j++) {
                if (freq[j] > freq[cHigh]) {
                    cHigh = (char) j;
                }
            }

            // Append the character to the result string as per its frequency
            while (freq[cHigh] != 0) {
                str[i++] = cHigh;
                freq[cHigh]--;
            }
        }

        return new String(str);
    }
}
