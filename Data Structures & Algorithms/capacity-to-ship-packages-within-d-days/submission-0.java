class Solution {
    private boolean canShip(int[] weights, int days, int cap) {
        int ships = 1, currCap = cap;
        for (int w : weights) {
            if (currCap - w < 0) {
                ships++;
                if (ships > days) {
                    return false;
                }
                currCap = cap;
            }
            currCap -= w;
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        if(weights.length <= days)return Arrays.stream(weights).max().getAsInt();
        
        
        int min = Arrays.stream(weights).max().getAsInt();
        int max = Arrays.stream(weights).sum();

        int potentialCapacity = max;

        while(min<=max){
            int mid = min + (max-min) /2;
            if(canShip(weights, days , mid)){
                potentialCapacity = Math.min(mid , potentialCapacity);
                max = mid-1;
            }else{
                min = mid+1;
            }

        }
        return potentialCapacity;

    }
}