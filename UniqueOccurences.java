Problem Link: https://leetcode.com/problems/unique-number-of-occurrences/?envType=daily-question&envId=2024-01-17

class UniqueOccurences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        HashSet<Integer> uniqueCounts = new HashSet<>();

        for (int count : countMap.values()) {
            if (!uniqueCounts.add(count)) {
                return false;
            }
        }

        return true;
    }
}
