Problem Link: https://leetcode.com/problems/furthest-building-you-can-reach/description/?envType=daily-question&envId=2024-02-17

class FurthestBuilding {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            if (diff > 0) {
                priorityQueue.offer(diff);

                if (priorityQueue.size() > ladders) {
                    bricks -= priorityQueue.poll();
                }

                if (bricks < 0) {
                    return i;
                }
            }
        }

        return heights.length - 1;        
    }
}
