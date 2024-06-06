Problem Link: https://leetcode.com/problems/hand-of-straights/description/?envType=daily-question&envId=2024-06-06

//Optimized
class HandOfStraightsHandOfStraishts {
    public boolean findsucessors(int[] hand, int groupSize, int i, int n) {
        int f = hand[i] + 1;
        hand[i] = -1;
        int count = 1;
        i += 1;
        while (i < n && count < groupSize) {
            if (hand[i] == f) {
                f = hand[i] + 1;
                hand[i] = -1;
                count++;
            }
            i++;
        }
        if (count != groupSize)
            return false;
        else
            return true;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)
            return false;
        Arrays.sort(hand);
        int i = 0;
        for (; i < n; i++) {
            if (hand[i] >= 0) {
                if (!findsucessors(hand, groupSize, i, n))
                    return false;
            }
        }
        return true;
    }
}



//Brute Force

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        Map<Integer, Integer> map = new TreeMap();

        for(int i=0;i<n;i++)
            map.put(hand[i], map.getOrDefault(hand[i], 0)+1);
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int freq = entry.getValue();
            while(freq>0) {
                //check a subset with size of groupSize elements
                for(int key=entry.getKey();key<(entry.getKey()+groupSize);key++) {
                    if(map.containsKey(key)) {
                        if(map.get(key) < 1)
                            return false;
                        map.put(key, map.get(key)-1);
                    }
                    else {
                        return false;
                    }
                }
                freq--;
            }
        }
        return true;
    }
}
