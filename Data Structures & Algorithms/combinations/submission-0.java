class Solution {
    private void createCombination(int n , int i , int k , 
                                    List<Integer> currList ,List<List<Integer>> finalList)

    {
        //base case 
        if(k == 0 ){
            finalList.add(new LinkedList<>(currList));
            return;
        }
        if(k < 0)return ;

        for(int j = i ; j<= n ;j++){
            currList.add(j);
            createCombination(n , j+1 , k-1 , currList , finalList);
            currList.remove(currList.size()-1);
        }


    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> finalCombination = new LinkedList<>();
        createCombination(n , 1 , k , new LinkedList<>() , finalCombination);
        return finalCombination;
    }
}