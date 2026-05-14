class Solution {

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {1, -1, 0, 0};

    private void dfs(int[][] heights,
                     int x,
                     int y,
                     boolean[][] ocean) {

        ocean[x][y] = true;

        for (int k = 0; k < 4; k++) {

            int nx = x + dx[k];
            int ny = y + dy[k];

            // invalid cell
            if (nx < 0 || ny < 0 ||
                nx >= heights.length ||
                ny >= heights[0].length) {

                continue;
            }

            // already visited
            if (ocean[nx][ny]) {
                continue;
            }

            // water cannot flow upward
            if (heights[nx][ny] < heights[x][y]) {
                continue;
            }

            dfs(heights, nx, ny, ocean);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific DFS
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific);
        }

        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific);
        }

        // Atlantic DFS
        for (int j = 0; j < n; j++) {
            dfs(heights, m - 1, j, atlantic);
        }

        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1, atlantic);
        }

        List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {

                    answer.add(Arrays.asList(i, j));
                }
            }
        }

        return answer;
    }
}