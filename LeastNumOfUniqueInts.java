Problem Link: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/?envType=daily-question&envId=2024-02-16

class LeastNumOfUniqueInts {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        int[] frequencyCount = new int[arr.length + 1];
        int uniqueCount = 0;
        int currentFrequency = 1;

        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                currentFrequency++;
            } else {
                uniqueCount++;
                frequencyCount[currentFrequency]++;
                currentFrequency = 1;
            }
        }

        for (int i = 1; i < frequencyCount.length; i++) {
            int canRemove = Math.min(k / i, frequencyCount[i]);
            uniqueCount -= canRemove;
            k -= canRemove * i;
        }

        return uniqueCount;
    }
}
