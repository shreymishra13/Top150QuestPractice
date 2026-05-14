class Solution {
    private int minCost(int[] cost , int index , int dp[]){
        // base case
        if(index == cost.length){
            return 0 ;
        }
        if(dp[index] != -1)return dp[index];
        //we have 2 choices either I can choose i+1 , or i+2
        int oneStepCost = 0 , twoStepCost = 0;
        if(index < cost.length-1)
        oneStepCost = minCost(cost , index+1 , dp);

        if(index < cost.length -2)
         twoStepCost = minCost(cost , index+2 , dp);

        return  dp[index] = cost[index] + Math.min(oneStepCost , twoStepCost);
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[]  = new int[cost.length];
        Arrays.fill(dp , -1);
        return Math.min(minCost(cost , 0 , dp) , minCost(cost , 1 , dp));
    }
}
