class Solution {
    public int singleNumber(int[] nums) {
        int xorred = nums[0];

        for(int i = 1 ; i< nums.length ;i++){
            xorred ^= nums[i];
        }

        return xorred;
        
    }
}
