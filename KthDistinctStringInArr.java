Problem Link: https://leetcode.com/problems/kth-distinct-string-in-an-array/description/?envType=daily-question&envId=2024-08-05

class KthDistinctStringInArr {

    public String kthDistinct(String[] arr, int k) {
        Set<String> distinctStrings = new HashSet<>();
        Set<String> duplicateStrings = new HashSet<>();

        // First pass: Identify distinct and duplicate strings
        for (String str : arr) {
            // If the string is already in duplicateStrings, skip further processing
            if (duplicateStrings.contains(str)) {
                continue;
            }
            // If the string is in distinctStrings, it means we have seen it before,
            // so move it to duplicateStrings
            if (distinctStrings.contains(str)) {
                distinctStrings.remove(str);
                duplicateStrings.add(str);
            } else {
                distinctStrings.add(str);
            }
        }

        // Second pass: Find the k-th distinct string
        for (String str : arr) {
            if (!duplicateStrings.contains(str)) {
                // Decrement k for each distinct string encountered
                k--;
            }
            // When k reaches 0, we have found the k-th distinct string
            if (k == 0) {
                return str;
            }
        }

        return "";
    }
}
