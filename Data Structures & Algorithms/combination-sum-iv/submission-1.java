class Solution {
    private int findAllCombination(int[] nums , int target , int cache[] ){
        //base condition
        if(target == 0)return 1;

        if(cache[target] != -1)return cache[target];
       
     
        int take = 0;
            for(int i = 0 ; i<nums.length ;i++){
                if(target >= nums[i])
                take += findAllCombination(nums , target-nums[i] , cache );

            }
        
        

        return cache[target] = take ;




        // or skip the curr element
    }
    public int combinationSum4(int[] nums, int target) {
        int cache[] = new int[target+1];
        Arrays.fill(cache , -1);
        return findAllCombination(nums ,target , cache );
    }
}