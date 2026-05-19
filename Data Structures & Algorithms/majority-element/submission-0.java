class Solution {
    public int majorityElement(int[] nums) {
        int currElement = nums[0];
        int freq = 1;

        for (int i = 1; i < nums.length; i++) {
            if (freq == 0) {
                currElement = nums[i];
                freq = 1;
            } else if (currElement == nums[i]) {
                freq++;
            }else{
                freq--;
            }
        }
        return currElement;
    }
}