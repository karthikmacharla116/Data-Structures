Problem Link: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/?envType=daily-question&envId=2024-01-13

class AnagramString {
    public int minSteps(String s, String t) {
        int[] result = new int[26];
        byte[] sBytes = s.getBytes();
        byte[] tBytes = t.getBytes();
        for (byte b : sBytes) {
          result[b - 'a']++;
        }
        for (byte b : tBytes) {
          result[b - 'a']--;
        }
        int answer = 0;
        for (int i : result) {
          answer += Math.abs(i);
        }
        return answer / 2;
    }
}
