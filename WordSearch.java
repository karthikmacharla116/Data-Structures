Problem Link: https://leetcode.com/problems/word-search/description/?envType=daily-question&envId=2024-04-03

class WordSearch {
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (wordSearch(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean wordSearch(char[][] board, int row, int col, String word, int index) {
        if (index == word.length())
            return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col])
            return false;

        if (board[row][col] != word.charAt(index))
            return false;

        visited[row][col] = true;

        boolean found = wordSearch(board, row + 1, col, word, index + 1) ||
                        wordSearch(board, row - 1, col, word, index + 1) ||
                        wordSearch(board, row, col + 1, word, index + 1) ||
                        wordSearch(board, row, col - 1, word, index + 1);

        visited[row][col] = false; // Backtrack

        return found;
    }
}
