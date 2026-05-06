class Solution {
    private int binarySearch(int nums[] , int target , int high , int low){

        if(low > high){
            return -1;
        }


        int mid = low + (high-low) / 2;
        if(nums[mid] == target)return mid;
        if(nums[mid] < target){
            return binarySearch(nums , target , high , mid+1 );
        }else return binarySearch(nums , target , mid-1 , low);

    }
    public int search(int[] nums, int target) {
     return binarySearch(nums , target , nums.length-1 , 0);   
    }
}
