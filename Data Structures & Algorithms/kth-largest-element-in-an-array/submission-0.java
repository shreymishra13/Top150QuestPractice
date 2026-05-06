class Solution {
    private int usingSort(int[] nums , int k){
        Arrays.sort(nums);
        return nums[nums.length -k];
    }
    public int findKthLargest(int[] nums, int k) {
        return usingSort(nums , k);
    }
}
