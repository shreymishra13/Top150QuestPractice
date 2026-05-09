class Solution {
    private void create(int[] nums , int index , Set<List<Integer>> subSet , List<Integer> currList){
        //base case
        if(index == nums.length){
            subSet.add(new LinkedList<>(currList));
            return;
        }

        //we have two choices to choose the current element
        currList.add(nums[index]);
        create(nums , index+1 , subSet , currList);
        currList.remove(currList.size()-1);
        // or skip it.
        create(nums , index+1 , subSet , currList);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> subSet = new HashSet<>();
        Arrays.sort(nums);
        create(nums , 0 , subSet , new LinkedList<>());
        List<List<Integer>> finalList = new LinkedList<>();

        for(List<Integer> set : subSet){
            finalList.add(set);
        }
        return finalList;
        
    }
}
