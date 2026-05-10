class Solution {
    public int lastStoneWeight(int[] stones) {
    //    List<Integer> stonesList = new LinkedList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
       for(int stone : stones){
            pq.add(stone);
       }

       while(pq.size()>1){
        int last = pq.remove();
        int secondLast = pq.remove();
        if(last == secondLast){
            continue;
        }else{
            pq.add(Math.abs(last - secondLast));
        }
       }

       if(pq.size() == 0)return 0;
       return pq.remove();


       
       
    }
}
