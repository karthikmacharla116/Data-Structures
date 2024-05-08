Problem Link: https://leetcode.com/problems/relative-ranks/description/?envType=daily-question&envId=2024-05-08

class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> score[b]-score[a]);
                
        int length = score.length;

        for(int i=0; i<length;i++)
            heap.offer(i);

        String[] result = new String[length];

        int index = 0;
        while(!heap.isEmpty()) {

            int rank = heap.remove();
            switch(index) {
                case 0:
                    result[rank] = "Gold Medal";
                    break;
                case 1:
                    result[rank] = "Silver Medal";
                    break;
                case 2:
                    result[rank] = "Bronze Medal";
                    break;
                default:
                    result[rank] = String.valueOf(index+1);
            }
            index++;
        }
        return result;
    }
}
