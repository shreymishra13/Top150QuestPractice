class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum())return -1;

        int remainingGas =0;
        int n = gas.length;

        for(int i = 0 ; i< n ; i++){
            if(gas[i] + remainingGas < cost[i]){
                continue;
                // skipping this starting point
            }

            int curr = i;
            boolean isPossible = true;
            for(int k = 0 ; k<n ; k++){
                remainingGas = remainingGas + gas[curr] - cost[curr];
                curr++;
                curr %= n;
                if(remainingGas < 0){
                    //not possible for further movement;
                    remainingGas = 0;
                    isPossible = false;
                    break;
                }
            }
            if(isPossible)return i;

        }
        
    return -1;
    }
}
