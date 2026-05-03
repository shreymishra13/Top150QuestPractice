class Solution {
    private void findSubSets(int[] nums, 
                            int index, 
                            List<Integer> currentSet,
                            List<List<Integer>> finalSubsets) {

                                if(index == nums.length){
                                    finalSubsets.add(new ArrayList<>(currentSet));
                                    return;
                                }

                                //either current add or skip it
                                currentSet.add(nums[index]);
                                findSubSets(nums , index+1 ,currentSet , finalSubsets );
                                currentSet.remove(currentSet.size()-1);
                                findSubSets(nums , index+1 ,currentSet, finalSubsets );

                            }
        
        public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> finalSubsets = new ArrayList<>();
        findSubSets(nums , 0 , new ArrayList<>(), finalSubsets);
        return finalSubsets;
            }
}
