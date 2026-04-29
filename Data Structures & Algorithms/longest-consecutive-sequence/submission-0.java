class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1)return nums.length;

        Set<Integer> set = new HashSet<>();
        int longestLength = 0;

        for(int num : nums){
            set.add(num);
        }

        for(int num : nums){
            int currLength = 0;
            if(!set.contains(num-1)){
                // this is not our starting point so skip
                currLength++;
                int temp = num;
                while(set.contains(temp+1)){
                    currLength++;
                    temp++;
                }
                longestLength = Math.max(currLength , longestLength);
            }


        }

        return longestLength;

    }
}
