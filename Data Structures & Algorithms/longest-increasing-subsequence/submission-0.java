class Solution {
    private int findLongest(int[] nums , int index , int maxTillNow , int cache[][]){
        if(index == nums.length)return 0;
        if(cache[index][maxTillNow+1003] != -1)return cache[index][maxTillNow+1003];
        int choose = 0;
        if(nums[index] > maxTillNow){
            choose = findLongest(nums , index+1 , nums[index] , cache)+1;
        }
        int skip = findLongest(nums , index+1 , maxTillNow , cache);

        return cache[index][maxTillNow+1003] = Math.max(choose , skip);
    }
    public int lengthOfLIS(int[] nums) {
        int cache[][] = new int[nums.length][2005];
        for(int row[] : cache)Arrays.fill(row , -1);
        return findLongest(nums , 0 , -1001 , cache);
    }
}
