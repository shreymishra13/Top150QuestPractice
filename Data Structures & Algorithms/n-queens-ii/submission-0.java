class Solution {
    private int count;
    public int totalNQueens(int n) {
        this.count = 0;
        if (n == 1)
            return 1;

        // first create the board;
        char[][] board = createEmptyBoard(n);

        // start placing
        placeQueens(board, 0);

        return this.count;
    }
    private void placeQueens(char[][] board, int row) {
        if (row == board.length) {
            this.count++;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (canPlace(board, row, i)) {
                board[row][i] = 'Q';
                placeQueens(board, row + 1);
                board[row][i] = '.';
            }
        }
    }
    private boolean canPlace(char[][] board, int row, int col) {
        int n = board.length;

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Top-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Top-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private char[][] createEmptyBoard(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        return board;
    }
}