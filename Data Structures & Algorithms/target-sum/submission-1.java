class Solution {
    private int totalWays(int[] nums ,int target , int index){
        if(index == nums.length){
            if(target == 0){
                return 1;
            }
            return 0;
        }
        //either add
        int addWays = totalWays(nums , target-nums[index] , index+1);

        //or subtract
        int subWays = totalWays(nums , target + nums[index] , index+1);

        return addWays + subWays;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return totalWays(nums , target , 0);
    }
}
