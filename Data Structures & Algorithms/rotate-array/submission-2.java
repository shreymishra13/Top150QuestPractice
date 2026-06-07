class Solution {
    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];
        k %= nums.length;
        k = nums.length-k;

       
        int i = 0;
        for(int j = k ; j<nums.length ; j++){
            ans[i++] = nums[j];
        }
        for(int j = 0 ; j<k ; j++){
            ans[i++] = nums[j];
        }

        for(int j = 0; j<nums.length ;j++){
            nums[j] = ans[j]; 
        }
    }
}