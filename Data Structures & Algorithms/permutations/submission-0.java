class Solution {
    List<List<Integer>> allPerms;
    private void generatePermutations(int nums[]  , Set<Integer> usedSet , List<Integer> currList ){
        if(usedSet.size() == nums.length){
            allPerms.add(new LinkedList<>(currList));
            return ;
        }

        for(int i = 0 ;i<nums.length ;i++){
            if(usedSet.contains(nums[i]))continue;
            currList.add(nums[i]);
            usedSet.add(nums[i]);
            generatePermutations(nums, usedSet , currList);
            currList.remove(currList.size()-1);
            usedSet.remove(nums[i]);
        }

        
    }
    public List<List<Integer>> permute(int[] nums) {
        allPerms = new LinkedList<>();
        List<Integer> currList = new LinkedList<>();
        if(nums.length == 1){
            currList.add(nums[0]);
            allPerms.add(currList);
            return allPerms;
        }


        generatePermutations(nums , new HashSet<>() , currList);


        return allPerms;

    }
}
