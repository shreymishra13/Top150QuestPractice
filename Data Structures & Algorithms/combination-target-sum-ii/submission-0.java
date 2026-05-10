class Solution {
    private void findCombination(int[] candidates , int index , int target , List<Integer> currComb , Set<List<Integer>> combinationSet){


        //base cases
        if(target == 0 ){
            combinationSet.add(new LinkedList<>(currComb));
            return;
        }
        if(index == candidates.length || target < 0 ){
            return;
        }
        //now we have choice, 
        // either we can pick the current element 
        if(target >= candidates[index]){
            currComb.add(candidates[index]);
            findCombination(candidates , index+1 , target-candidates[index] ,currComb ,  combinationSet);
            currComb.remove(currComb.size()-1);
        }
        // or we can skip it
        findCombination(candidates , index +1 , target , currComb , combinationSet);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> combinationSet = new HashSet<>();
        Arrays.sort(candidates);
        findCombination(candidates , 0 , target , new LinkedList<>() , combinationSet);
        List<List<Integer>> combinationList = new LinkedList<>();
        for(List<Integer> combination : combinationSet){
            combinationList.add(combination);
        }

        return combinationList;
    }
}
