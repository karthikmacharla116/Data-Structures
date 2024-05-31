Problem Link: https://leetcode.com/problems/single-number-iii/description/?envType=daily-question&envId=2024-05-31

class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int xor2no = 0;
        for (int num : nums) {
            xor2no ^= num;
        }

        int lowestBit = xor2no & (-xor2no);

        int[] result = new int[2];
        for (int num : nums) {
            if ((lowestBit & num) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }
}

class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap();

        for(int n: nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0)+1);
        }
        int[] result = new int[2];
        int index = 0;
        for(Map.Entry<Integer, Integer> e: freqMap.entrySet()) {
            if(e.getValue() == 1)
                result[index++] = e.getKey();
        }
        return result;
    }
}
