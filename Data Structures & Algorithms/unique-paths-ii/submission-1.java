class Solution {
    private int calculatePaths(int[][] obstacle , int x , int y , int m , int n , int[][] dp){

        if(x >= m || y >= n || obstacle[x][y] == 1)return 0;
        if(x == m-1 && y == n-1)return 1;
        if(dp[x][y] != -1)return dp[x][y];

        int rightPath = calculatePaths(obstacle , x , y+1 , m , n , dp);
        int downPath = calculatePaths(obstacle , x+1 , y , m , n , dp);

        return dp[x][y] = downPath + rightPath;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length ;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];
        for(int row[] : dp)Arrays.fill(row , -1);
        return calculatePaths(obstacleGrid , 0 , 0 , obstacleGrid.length , obstacleGrid[0].length, dp);
    }
}