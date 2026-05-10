class Solution {

    private void dfs(char[][] board,
                     int x,
                     int y,
                     boolean[][] isVis) {

        isVis[x][y] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            // valid connected O cell
            if (nx < 0 || ny < 0 ||
                nx >= board.length ||
                ny >= board[0].length ||
                board[nx][ny] == 'X' ||
                isVis[nx][ny]) {

                continue;
            }

            dfs(board, nx, ny, isVis);
        }
    }

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] isVis = new boolean[m][n];

        // first row
        for (int j = 0; j < n; j++) {

            if (board[0][j] == 'O') {
                dfs(board, 0, j, isVis);
            }
        }

        // last row
        for (int j = 0; j < n; j++) {

            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j, isVis);
            }
        }

        // first column
        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O') {
                dfs(board, i, 0, isVis);
            }
        }

        // last column
        for (int i = 0; i < m; i++) {

            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1, isVis);
            }
        }

        // convert only surrounded O's
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O' &&
                    !isVis[i][j]) {

                    board[i][j] = 'X';
                }
            }
        }
    }
}