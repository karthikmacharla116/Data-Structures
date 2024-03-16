Problem Link: https://leetcode.com/problems/contiguous-array/description/?envType=daily-question&envId=2024-03-16

public class ContigousBinaryArray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlength = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlength = Math.max(maxlength, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlength;
    }
}
