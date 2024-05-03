Problem Link: https://leetcode.com/problems/compare-version-numbers/description/?envType=daily-question&envId=2024-05-03

class CompareVersionNos {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int i = 0;
        int j = 0;

        while (i < arr1.length || j < arr2.length) {
            int v1 = i < arr1.length ? Integer.parseInt(arr1[i]) : 0;
            int v2 = j < arr2.length ? Integer.parseInt(arr2[j]) : 0;

            if (v1 != v2) {
                return Integer.compare(v1, v2);
            }
            i++;
            j++;
        }

        return 0;
    }
}
