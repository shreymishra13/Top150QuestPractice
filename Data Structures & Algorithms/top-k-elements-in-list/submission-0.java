
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> numFreqMap = new HashMap<>();

        for(int num : nums){
            numFreqMap.put(num , numFreqMap.getOrDefault(num ,0)+1);
        }

        PriorityQueue<int[]> mostFreq = new PriorityQueue<>((a ,b)->{
            return a[1]-b[1];
        });

        for(int key : numFreqMap.keySet()){
            mostFreq.add(new int[]{key, numFreqMap.get(key)});
            if(mostFreq.size() > k){
                mostFreq.remove();
            }
        }

        int[] ele = new int[k];
        int i = 0;
        while(!mostFreq.isEmpty()){
            ele[i++] = mostFreq.remove()[0];
            
        }
        return ele;
        
    }
}
