class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)return 0;
        int maxProfit = 0;
        int maxSoFar[] = new int[prices.length];
        maxSoFar[prices.length-1] = prices[prices.length-1];

        for(int j = prices.length-2 ; j>=0 ; j--){
            maxSoFar[j] = Math.max(prices[j] , maxSoFar[j+1]);
        }

        for(int i = 0 ; i<prices.length ; i++){
            maxProfit = Math.max(maxSoFar[i]-prices[i] , maxProfit);

        }
        return maxProfit;

      
    }
}
