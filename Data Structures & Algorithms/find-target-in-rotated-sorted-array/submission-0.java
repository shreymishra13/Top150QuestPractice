class Solution {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1 ; 

        if(nums[left] == target)return 0;
        if(nums[right] == target)return right;

        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target)return mid;
            //check in the sorted region, if not then move for another
            if(nums[mid] > nums[left]){
                //left region is sorted
                if(target > nums[left] && target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                //right region is sorted
                if(target > nums[mid] && target < nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
       return -1;
        
    }
}
