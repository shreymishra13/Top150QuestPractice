class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(k == arr.length)return Arrays.stream(arr).boxed().collect(Collectors.toList());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)->{
               if( Math.abs(a-x) == Math.abs(b-x))return Integer.compare(b,a);
               return Math.abs(b-x) - Math.abs(a-x);
            }
        );

        for(int ele : arr){
            pq.add(ele);
            if(pq.size()>k){
                pq.poll();
            }
        }

       List<Integer> sortedList = new ArrayList<>();
while (!pq.isEmpty()) {
    sortedList.add(pq.poll());
}
Collections.sort(sortedList);
        
return sortedList;
    }
}