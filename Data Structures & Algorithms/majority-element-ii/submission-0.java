class Solution {
    private List<Integer> bruteforceUsingHashMap(int[] nums){
        int n = nums.length;
        int minReq = (int)Math.floor(n/3);
        Map<Integer , Integer> numFreqMap = new HashMap<>();
        List<Integer> majElements = new LinkedList<>();
        for(int num : nums){
            numFreqMap.putIfAbsent(num , 0);
            numFreqMap.put(num , numFreqMap.get(num)+1);
           
        }
        for(int num : numFreqMap.keySet()){
            if(numFreqMap.get(num)>minReq){
                majElements.add(num);
            }
        }
        System.out.println(numFreqMap + "-->"+minReq);
        return majElements;
    }
    public List<Integer> majorityElement(int[] nums) {
        return bruteforceUsingHashMap(nums);
    }
}