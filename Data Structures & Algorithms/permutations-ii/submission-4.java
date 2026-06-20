class Solution {
    List<List<Integer>> uniquePerm ;

    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Map<Integer, Integer> numFreqMap = new HashMap<>();
        uniquePerm = new LinkedList<>();
        for(int num : nums){
            numFreqMap.put(num , numFreqMap.getOrDefault(num , 0) + 1);
        }
        generateUniquePerm(nums ,  numFreqMap , new LinkedList<>());
        return uniquePerm;
    }

    private void generateUniquePerm(int[] nums , Map<Integer,Integer> map , 
                                    List<Integer> currList )
    {

        if( currList.size() == nums.length){
            uniquePerm.add(new LinkedList<>(currList));
            return;
        }

     

        for(int key : map.keySet()){
            if(map.get(key) > 0){
                currList.add(key);
                map.put(key , map.get(key)-1);
                generateUniquePerm(nums ,map , currList);
                currList.remove(currList.size()-1);
                map.put(key , map.get(key)+1);
            }
        }

    }
}