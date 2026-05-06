class Solution {
    private int usingSort(int[] nums , int k){
        Arrays.sort(nums);
        return nums[nums.length -k];
    }
    private int usingPriorityQueue(int[] nums , int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.poll();
    }
    public int findKthLargest(int[] nums, int k) {
        // return usingSort(nums , k);
        return usingPriorityQueue(nums , k);
    }
}
