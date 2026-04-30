class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)return 0;
        int maxProfit = 0;
       int maxSoFar = prices[prices.length-1];

       for(int j = prices.length-2 ; j>=0 ;j--){
            maxSoFar = Math.max(maxSoFar , prices[j]);
            maxProfit = Math.max(maxProfit , maxSoFar - prices[j]);
       }
       return maxProfit;

      
    }
}
