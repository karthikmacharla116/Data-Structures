package dsa;

import java.util.Arrays;

public class NumberOfIslandsII {
    public static DisjointSet dSet;
    public static final int[] dir = {0, 1, 0, -1, 0};

    public static void main(String[] args) {
        int m = 4;
        int n = 5;

        int[][] queries = {{0,0}, {0,0}, {1,1}, {0,1}, {1,0}, {0,3}, {1,3}, {0,4}, {3,2},
                {2,2}, {1,2}, {0,2}};

        dSet = new DisjointSet(m*n);
        int[] ans = new int[queries.length];
        boolean[][] visited = new boolean[m][n];

        islandsHelper(m, n, queries, visited, ans);
        System.out.println(Arrays.toString(ans));
    }

    static void islandsHelper(int m, int n, int[][] queries, boolean[][] visited, int[] ans) {
        int islandCnt = 0;
        for(int index=0;index<queries.length;index++) {
            int row = queries[index][0];
            int col = queries[index][1];

            if(!visited[row][col]) {
                visited[row][col] = true;
                islandCnt += 1;

                int nodeU = row*n + col;
                //check all the adj nodes to nodeU
                for(int d=0;d<4;d++) {
                    int new_row = row + dir[d];
                    int new_col = col + dir[d+1];
                    if(isValidNode(new_row, new_col, m, n, visited)) {
                        int nodeV = new_row * col + new_col;
                        //step1 : Check ultimate parents of nodeU and nodeV
                        int ulp_nodeU = dSet.findParent(nodeU);
                        int ulp_nodeV = dSet.findParent(nodeV);
                        if(ulp_nodeU != ulp_nodeV) {
                            dSet.unionBySize(nodeU, nodeV);
                            islandCnt -= 1;
                        }
                    }
                }
            }
            ans[index] = islandCnt;
        }
    }

    private static boolean isValidNode(int newRow, int newCol, int m, int n, boolean[][] visited) {
        return newRow >=0 && newCol >= 0 && newRow < m && newCol < n && visited[newRow][newCol];
    }
}
