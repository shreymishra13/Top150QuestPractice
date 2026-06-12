class Solution {
    private int minimizeTheJump(int nums[] , int i , int cache[]){
        if(i >= nums.length -1)return 0;
        if(cache[i] != -1)return cache[i];

        int res = Integer.MAX_VALUE-1;
        for(int j = 1 ; j<= Math.min(nums.length-1  , nums[i]) ; j++){
            int nextI = i + j;
            res = Math.min(res , 1+ minimizeTheJump(nums , nextI ,cache));
        }
        return cache[i] = res;
        
    }
    public int jump(int[] nums) {
        int cache[] = new int[nums.length];
        Arrays.fill(cache , -1);
        return minimizeTheJump(nums , 0 , cache);
    }
}
