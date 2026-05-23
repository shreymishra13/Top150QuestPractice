class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        if(!(nums[0]<= target && nums[nums.length-1]>= target))return false;

        int left = 0;
        int right = nums.length-1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target)left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}