class Solution {
    List<List<Integer>> allComb;
    private void findCombination(int[] nums , int target , int index , List<Integer> currComb){
        //base case
        
        if(target == 0){
            //found our combination
            allComb.add(new LinkedList<>(currComb));
            return;
        }
        else if(target < 0 || index == nums.length){
            return ;
        }

        //either choose the current element 
        currComb.add(nums[index]);
        findCombination(nums , target - nums[index] , index , currComb);
        currComb.remove(currComb.size()-1);
        //skip the current element
        findCombination(nums , target , index+1 , currComb);

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        allComb = new LinkedList<>();
        findCombination(nums , target , 0 , new LinkedList<>());
        return allComb;
    }
}
