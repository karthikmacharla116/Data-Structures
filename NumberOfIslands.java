Problem Link: https://leetcode.com/problems/number-of-islands/description/?envType=daily-question&envId=2024-04-19

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int numIslands = 0;

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    stack.push(new int[]{i, j});

                    grid[i][j] = '0';

                    while (!stack.isEmpty()) {
                        int[] cell = stack.pop();
                        int row = cell[0];
                        int col = cell[1];

                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            stack.push(new int[]{row - 1, col});
                            grid[row - 1][col] = '0'; // Mark cell as visited
                        }
                        if (row + 1 < rows && grid[row + 1][col] == '1') {
                            stack.push(new int[]{row + 1, col});
                            grid[row + 1][col] = '0'; 
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            stack.push(new int[]{row, col - 1});
                            grid[row][col - 1] = '0'; 
                        }
                        if (col + 1 < cols && grid[row][col + 1] == '1') {
                            stack.push(new int[]{row, col + 1});
                            grid[row][col + 1] = '0'; 
                        }
                    }
                }
            }
        }

        return numIslands;
    }
}
