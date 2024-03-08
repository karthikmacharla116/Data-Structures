Problem Link: https://leetcode.com/problems/count-elements-with-maximum-frequency/description/?envType=daily-question&envId=2024-03-08

class MaxFrequencyElementsCount {
    public int maxFrequencyElements(int[] nums) {
        int count = 0;
        int maxFrequency = 0;
        Map<Integer, Integer> frequencyMap = new HashMap();

        for (int num : nums) {
            int frequency = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, frequency);

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                count = frequency; 
            } else if (frequency == maxFrequency) {
                count += frequency; 
            }
        }

        return count;
    }
}
