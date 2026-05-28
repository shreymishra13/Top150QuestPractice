class Solution {

    // private int minimize(List<Integer> nums , int index , int targetSum ,int[][] dp){
    //     //base case

    //     if(index == nums.size()){
    //         if(targetSum == 0)return 0;
    //         return Integer.MAX_VALUE;
    //     }
       
    //     if(targetSum <0)return Integer.MAX_VALUE;
    //     if(dp[index][targetSum] != -1)return dp[index][targetSum];

    //     //we have two option: 
    //     // either two chose the current element or skip it
    //     int chosen = Integer.MAX_VALUE;
    //     if(targetSum >= nums.get(index)){
    //         chosen = minimize(nums , index , targetSum-nums.get(index) , dp);
    //     }
    //     if(chosen!=Integer.MAX_VALUE)chosen++;
    //     int skip = minimize(nums , index+1 , targetSum , dp);

    //     return dp[index][targetSum] = Math.min(chosen , skip);
    // }
    // public int numSquares(int n) {
    //     List<Integer> perfectSquares = new ArrayList<>();
    //     for(int i = 1 ; i*i<= n ; i++){
    //         perfectSquares.add(i*i);
    //     }

    //     int dp[][] = new int[perfectSquares.size()][n+1];
    //     for(int row[] : dp){
    //         Arrays.fill(row,-1);
    //     }
    //     return minimize(perfectSquares , 0 , n , dp);


        
    // }
 

    public int numSquares(int n) {

        // dp[i] = minimum perfect squares needed to form i
        int[] dp = new int[n + 1];

        // initialize with large value
        Arrays.fill(dp, Integer.MAX_VALUE);

        // base case
        dp[0] = 0;

        // build answers from 1 -> n
        for (int target = 1; target <= n; target++) {

            // try every perfect square <= target
            for (int i = 1; i * i <= target; i++) {

                int square = i * i;

                dp[target] = Math.min(
                    dp[target],
                    1 + dp[target - square]
                );
            }
        }

        return dp[n];
    }

}