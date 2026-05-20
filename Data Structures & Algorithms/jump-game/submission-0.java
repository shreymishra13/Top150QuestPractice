class Solution {
    private boolean canJum (int nums[] , int index , short[] dp){
        if(index == nums.length-1)return true;

        if(dp[index] == 1)return true;
        if(dp[index] == 0)return false;
        boolean can = false;
        for(int i = 1 ; i<= Math.min(nums.length-1 , nums[index]) ; i++){
            can = canJum(nums , index+i , dp);
            if(can){
                dp[index+i] = 1;
                return true;
            }
        }

         dp[index] = 0;
         return can;
    }
    public boolean canJump(int[] nums) {
        short dp[] = new short[nums.length];
        Arrays.fill(dp , (short )-1);

        return canJum(nums , 0 , dp);
    }
}
