class Solution {
    private boolean whoWon(Deque<Integer> piles , boolean isAliceTurn ,
                             int aliceScore , int bobScore )
    {
        //base case 
        if(piles.size() == 0){
            return aliceScore>bobScore;
        }


        if(isAliceTurn){
            int leftVal = piles.pollFirst();
            boolean left = whoWon(piles, !isAliceTurn , aliceScore+leftVal , bobScore);
            piles.addFirst(leftVal);
            int rightVal = piles.pollLast();
            boolean right = whoWon(piles , !isAliceTurn , aliceScore+rightVal , bobScore);

            return left || right;
        }else{

            int leftVal = piles.pollFirst();
            boolean left = whoWon(piles, !isAliceTurn , aliceScore , bobScore+leftVal);
            piles.addFirst(leftVal);
            int rightVal = piles.pollLast();
            boolean right = whoWon(piles , !isAliceTurn , aliceScore , bobScore+rightVal);
            piles.addLast(rightVal);

            return left || right;
        }


    }
    public boolean stoneGame(int[] piles) {
         Deque<Integer> deque = new ArrayDeque<>();
         for(int pile : piles){
            deque.addLast(pile);
         }

         return whoWon(deque , true , 0 , 0);


    }
}