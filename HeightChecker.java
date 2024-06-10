Problem Link: https://leetcode.com/problems/height-checker/description/?envType=daily-question&envId=2024-06-10

  Can also be solved using "Count Sort"

//Brute force
class HeightChecker {
    public int heightChecker(int[] heights) {
        int n = heights.length;

        int[] expected = new int[n];
        for(int i=0;i<n;i++)
            expected[i] = heights[i];
        
        Arrays.sort(expected);

        int cnt = 0;
        for(int i=0;i<n;i++) {
            if(heights[i] != expected[i])
                cnt++;
        }
        return cnt;
    }
}
