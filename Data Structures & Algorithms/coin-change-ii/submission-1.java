class Solution {
    private int count(int amount , int[] coins , int index){

        //base case
        if(index == coins.length){
            if(amount == 0)return 1;
            else return 0;
        }


        //two choices
        // either to pick
        int pick = 0;
        if(amount >= coins[index])
         pick = count(amount-coins[index] , coins , index);
        // or skip
        int skip = count(amount , coins , index+1);

        return pick + skip;



    }

     private int countOptimized(int amount , int[] coins , int index , int dp[][]){

        //base case
        if(index == coins.length){
            if(amount == 0)return 1;
            else return 0;
        }

        if(dp[index][amount] != -1){
            return dp[index][amount];
        }

        //two choices
        // either to pick
        int pick = 0;
        if(amount >= coins[index])
         pick = countOptimized(amount-coins[index] , coins , index , dp);
        // or skip
        int skip = countOptimized(amount , coins , index+1 , dp);

        dp[index][amount] =  pick + skip;
        return dp[index][amount];



    }
    public int change(int amount, int[] coins) {
        int dps[][] = new int[coins.length][amount+1];
        for(int[] dp : dps){
            Arrays.fill(dp , -1);
        }
        return countOptimized(amount , coins , 0 , dps);
       
        
    }
}
