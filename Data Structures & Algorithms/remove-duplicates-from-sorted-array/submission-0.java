class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1)return 1;
        int sortedIndex = 0;
        int currElementIndex = 1;

        while(currElementIndex < nums.length){
            int vacantPlaceIndex = sortedIndex+1;
            if(nums[currElementIndex] != nums[sortedIndex]){
                nums[vacantPlaceIndex] = nums[currElementIndex];
                sortedIndex++;

            }
            currElementIndex++;
        }
        return sortedIndex+1;

        
    }
}