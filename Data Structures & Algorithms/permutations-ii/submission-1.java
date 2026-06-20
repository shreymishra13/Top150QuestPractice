class Solution {
    List<List<Integer>> uniquePerm ;

    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Map<Integer, Integer> numFreqMap = new HashMap<>();
        uniquePerm = new LinkedList<>();
        for(int num : nums){
            numFreqMap.put(num , numFreqMap.getOrDefault(num , 0) + 1);
        }
        generateUniquePerm(nums ,  numFreqMap , new LinkedList<>() , new HashSet<>() );
        return uniquePerm;
    }

    private void generateUniquePerm(int[] nums , Map<Integer,Integer> map , 
                                    List<Integer> currList , Set<String> unique)
    {

        if( currList.size() == nums.length){
            // System.out.println(currList);
            if(unique.contains(currList.toString())){
                return ;
            }
            unique.add(currList.toString());
            uniquePerm.add(new LinkedList<>(currList));
            return;
        }

        for(int num : nums){
            if(map.get(num) > 0){
                currList.add(num);
                map.put(num , map.get(num)-1);
                generateUniquePerm(nums ,map , currList , unique);
                currList.remove(currList.size()-1);
                map.put(num , map.get(num)+1);
            }
        }

    }
}