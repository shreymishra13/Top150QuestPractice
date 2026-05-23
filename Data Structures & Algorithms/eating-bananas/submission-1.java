class Solution {
    private boolean validate(int[] piles , int h , int k){

        int sum = 0;
        for(int pile : piles){
            sum += (Math.ceil(pile * 1.0/k));
        }
        if(sum<= h){
            return true;
        }
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {

        if(h == piles.length) return Arrays.stream(piles).max().getAsInt();
        
        int minVal = 1;
        int maxVal = Arrays.stream(piles).max().getAsInt();
        int minSpeed = Integer.MAX_VALUE;
        while(minVal <= maxVal){
            int midVal = minVal + (maxVal-minVal)/2;

            //check if it is valid If yes.. shift towards left to minimize it 
            if(validate(piles , h , midVal)){
                minSpeed = Math.min(midVal , minSpeed);
                maxVal = midVal-1;
            }


            // else towards right to find the value
            else{
                minVal = midVal+1;
            }
        }
        System.out.println(minVal);

        return minSpeed;
        
    }
}
