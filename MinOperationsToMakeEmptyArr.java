Problem Link:https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/description/?envType=daily-question&envId=2024-01-04

class MinOperationsToMakeEmptyArr {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        //freq count
        for(int i: nums) {
            if(map.containsKey(i))
                map.put(i, map.get(i)+1);
            else
                map.put(i, 1);
        }
        
        int minOperations =  0;
        for(Integer i: map.values()) {
            if(i<2)
                return -1;
            minOperations += Math.ceil((double)i/3);    
        }
        return minOperations;

    }
}
