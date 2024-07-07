Problem Link: https://leetcode.com/problems/water-bottles/description/?envType=daily-question&envId=2024-07-07

class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        if(numBottles < numExchange)
            return numBottles;
        
        int total = numBottles;
        int bottlesConsumed = 0;
        while(numBottles >= numExchange) {
            bottlesConsumed = (numBottles/numExchange);
            total += bottlesConsumed;
            numBottles = (numBottles%numExchange);
            numBottles += bottlesConsumed;
        }
        return total;
    }
}
