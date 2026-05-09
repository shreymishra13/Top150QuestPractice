class Solution {
    private int findMaxAmount(int [] nums , int index , int dp[]){
        if(index >= nums.length){
            return 0;
        }
        if(dp[index] != -1)return dp[index];


        int skip = findMaxAmount(nums , index+1 ,dp) ;
        int choose = nums[index] + findMaxAmount(nums , index+2 , dp);

      return  dp[index] = Math.max(skip , choose);
    
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp , -1);
        return findMaxAmount(nums , 0 , dp);
    }
}
