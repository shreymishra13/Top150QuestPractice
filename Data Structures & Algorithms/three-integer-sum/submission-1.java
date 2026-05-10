class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new LinkedList<>();
        Arrays.sort(nums);
        Set<List<Integer>> tripletSet = new HashSet<>();

        for (int i = 0; i < nums.length - 2;) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (-nums[i] == nums[j] + nums[k]) {
                    tripletSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }else if( -nums[i] < nums[j] + nums[k]){
                    k--;
                }else{
                    j++;
                }
            }
            do{
                i++;

            }
            while(i < nums.length-2 && nums[i] == nums[i-1] );

        }

        for(List<Integer> triplet : tripletSet){
            triplets.add(triplet);
        }

        return triplets;
    }
}
