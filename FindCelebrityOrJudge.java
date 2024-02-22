Problem Links: https://leetcode.com/problems/find-the-town-judge/description/,
https://leetcode.com/problems/find-the-celebrity/description/

class FindCelebrityOrJudge {
    public int findJudge(int n, int[][] trust) {
        
        //Graph
        int[] inDegrees = new int[n+1];
        int[] outDegrees = new int[n+1];

        for(int[] arr: trust) {
            outDegrees[arr[0]]++;
            inDegrees[arr[1]]++;
        }
        for(int i=1;i<=n;i++) {
            if(inDegrees[i] == n-1 && outDegrees[i] == 0)
                return i;
        }
        return -1;
    }
}
