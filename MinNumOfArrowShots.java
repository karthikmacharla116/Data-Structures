Problem Link: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/?envType=daily-question&envId=2024-03-18

class MinNumOfArrowShots {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int arrows = 0;
        long prevLast = points[0][1];

        for(int i=1;i<points.length;i++) {

            if(prevLast >= points[i][0]) {
                if(prevLast > points[i][1])
                    prevLast = points[i][1];
            } else {
                prevLast = points[i][1];
                arrows++;
            }
        }


        return arrows + 1;
    }
}
