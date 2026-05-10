class Solution {
    private int countNumOfWays(int m , int n , int i , int j , int dp[][]){

        if(i == m-1 && j == n-1){
            return 1;
        }
        if(i >= m || j >= n)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        // either I can move down 
        int down = countNumOfWays(m , n , i+1 , j , dp);
        // or move right
        int right = countNumOfWays(m , n , i , j+1 , dp);

        return dp[i][j] = down + right;

    }
    public int uniquePaths(int m, int n) {
        if(m ==1 && n==1)return 1;
        int dp[][] = new int[m][n];
        for(int row[] : dp){
            Arrays.fill(row , -1);
        }
        return countNumOfWays(m , n , 0 , 0 , dp);
    }
}
