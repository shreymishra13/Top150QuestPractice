class Solution {
    private int rob(int nums[] , int i , int endInd , int cache[]){
        if(i >= endInd){
            return 0;
        }

        if(cache[i] != -1)return cache[i];
        //eitther we can choose it 
        int choose = nums[i] + rob(nums , i+2 , endInd , cache);
        // or skip it
        int skip = rob(nums , i+1 , endInd , cache);

        return cache[i] = Math.max(choose , skip);

    }
    public int rob(int[] nums) {
        if(nums.length == 1)return nums[0];
        int arr1[] = new int[nums.length];
        int arr2[] = new int[nums.length];
        Arrays.fill(arr1 , -1);
        Arrays.fill(arr2, -1);

        return Math.max(rob(nums , 1 , nums.length , arr1) , rob(nums , 0 , nums.length-1 , arr2 ));

    }
}
