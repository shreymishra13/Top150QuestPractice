class Solution {
    private int count(int amount , int[] coins , int index){

        //base case
        if(index == coins.length){
            if(amount == 0)return 1;
            else return 0;
        }


        //two choices
        // either to pick
        int pick = 0;
        if(amount >= coins[index])
         pick = count(amount-coins[index] , coins , index);
        // or skip
        int skip = count(amount , coins , index+1);

        return pick + skip;



    }
    public int change(int amount, int[] coins) {

        return count(amount , coins , 0);
       
        
    }
}
