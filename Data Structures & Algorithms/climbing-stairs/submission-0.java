class Solution {

    private int countNumberOfWays(int n , int[] dp){
        if(n == 0){
            return 1;
        }else if(n < 0 )return 0;

        if(dp[n] != -1)return dp[n];

        dp[n] =  climbStairs(n-1) + climbStairs(n-2);
        return dp[n];
    }
    public int climbStairs(int n) {
        if(n == 1)return 1;
        int dp[] = new int[n+1];
        Arrays.fill(dp , -1);
        return countNumberOfWays(n, dp);
    }
}
