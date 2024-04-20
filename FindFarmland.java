Problem Link: https://leetcode.com/problems/find-all-groups-of-farmland/description/?envType=daily-question&envId=2024-04-20

class FindFarmland {
    public int[][] findFarmland(int[][] land) {
        int N = land.length, M = land[0].length;
        List<int[]> ans = new ArrayList<>();

        for (int row1 = 0; row1 < N; row1++) {
            for (int col1 = 0; col1 < M; col1++) {
                if (land[row1][col1] == 1) {
                    int x = row1, y = col1;

                    for (x = row1; x < N && land[x][col1] == 1; x++) {
                        for (y = col1; y < M && land[x][y] == 1; y++) {
                            land[x][y] = 0;
                        }
                    }

                    int[] arr = new int[] {row1, col1, x - 1, y - 1};
                    ans.add(arr);
                }
            }
        }
        return ans.stream().toArray(int[][] :: new);
    }
}
