Problem Link: https://leetcode.com/problems/most-profit-assigning-work/description/?envType=daily-question&envId=2024-06-18

//Optimized
class Pair {
    int difficultyLevel;
    int profitLevel;
    Pair(int difficultyLevel, int profitLevel){
        this.difficultyLevel = difficultyLevel;
        this.profitLevel = profitLevel;
    }
}
class MostProfitAssigningWork {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    int length =difficulty.length;
    if(length ==0) return 0;
    Pair[] pairs = new Pair[length];
    for(int i =0; i < length ; i++){
        pairs[i] = new Pair(difficulty[i], profit[i]);
    }
    Arrays.sort(pairs , (a,b) ->a.difficultyLevel - b.difficultyLevel);
    int maxProfit =0;
    Arrays.sort(worker);
    int bestPaySoFar =0;
    int i = 0;
    for(int k = 0; k < worker.length; k++){
        int ability = worker[k];
        while(i < pairs.length && ability >= pairs[i].difficultyLevel){
            if(bestPaySoFar < pairs[i].profitLevel) {
                bestPaySoFar = pairs[i].profitLevel;
            }
            i++;
        }  
        maxProfit +=  bestPaySoFar;   
    }
    return maxProfit;
    }
}


//Brute force
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length;
        int m = worker.length;

        int maxProfit = 0;

        for(int w=0;w<m;w++) { //Time complexity = O(m*n)
            int prof = 0;
            for(int job=0;job<n;job++) {
                if(worker[w] >= difficulty[job]) {
                    prof = Math.max(prof, profit[job]);
                }
            }
            maxProfit += prof;
        }
        return maxProfit;
    }
}
