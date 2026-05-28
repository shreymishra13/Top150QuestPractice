class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length <= 1)return false;
        int n = nums.length;
        for(int i = 0 ; i<n ; i++){
            for(int j = i+1 ; j<=Math.min(i+k, n-1) ; j++){
                if(nums[i] == nums[j])return true;
            }
        }
        return false;

    }
}