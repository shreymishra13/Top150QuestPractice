class Solution {
    public boolean canJump(int[] nums) {
        
        int size = nums.length;
        int currGoalIndex = size-1;   
        int currIndex = size-2; 

        while(currIndex >= 0){
            if(nums[currIndex] >= currGoalIndex - currIndex ){
                //we got our new goal 
                currGoalIndex = currIndex;
                // and shift towards left 
               
            }
             currIndex--;

        }
        return currGoalIndex == 0 ;  
    }
}
