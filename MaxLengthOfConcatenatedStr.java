Problem Link: https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/?envType=daily-question&envId=2024-01-23

class MaxLengthOfConcatenatedStr {
    public int maxLength(List<String> arr) {
        return recursion(arr, 0, 0);
    }

    private int recursion(List<String> arr, int index, int bitmask) {
        if (index == arr.size()) {
            return Integer.bitCount(bitmask);
        }

        int withoutCurrent = recursion(arr, index + 1, bitmask);
        int withCurrent = 0;

        int currentMask = 0;
        String currentString = arr.get(index);
        for (char c : currentString.toCharArray()) {
            int charBit = 1 << (c - 'a');
            if ((currentMask & charBit) == 0) {
                currentMask |= charBit;
            } else {
                // If there is a duplicate character, we'll set the bitmask to 0
                currentMask = 0;
                break;
            }
        }

        if (currentMask == 0 || (bitmask & currentMask) == 0) {
            withCurrent = recursion(arr, index + 1, bitmask | currentMask);
        }

        return Math.max(withoutCurrent, withCurrent);
    }
}
