class Solution {
    private int bruteForce(int[] nums , int target){
        // find all the subarrays and get the sum of each.. 
        int count = 0;

        for(int i =0 ; i<nums.length; i++){
            for(int j = i ; j< nums.length ;j++){
                    int sum = 0;
                for(int k = i ; k<= j ; k++){
                    sum+= nums[k];
                }

                if(sum == target)count++;
            }
        }
        return count;
    }
    private int optimized(int [] nums , int target){
        int prefix[] = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1 ; i < nums.length ;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        int count = 0;
        for(int i = -1 ; i < nums.length-1; i++){
            for(int j = i+1 ; j<nums.length ; j++){
                if(i == -1){
                    if(prefix[j] == target)count++;
                }else{
                    if(prefix[j] - prefix[i] == target){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public int subarraySum(int[] nums, int k) {
        return optimized(nums , k);
    }
}