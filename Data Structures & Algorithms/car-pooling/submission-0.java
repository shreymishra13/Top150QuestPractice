class Solution {
    public boolean carPooling(int[][] trips, int maxCapacity) {

        if(trips.length == 1){
            if(maxCapacity < trips[0][0])return false;
            else return true;
        }

        Arrays.sort(trips , (a , b) ->{
            return a[1] - b[1];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
           return a[2] - b[2];
        });

        int currentCapacity = 0;

        for(int i = 0 ; i<trips.length ;i++){
            int capacity = trips[i][0];
            int startTime = trips[i][1];
            int endTime = trips[i][2];

            while(!pq.isEmpty() && pq.peek()[2] <= startTime){
                int[] droppedPassenger = pq.remove();
                currentCapacity -= droppedPassenger[0];

            }
            currentCapacity += capacity;
            if(currentCapacity > maxCapacity)return false;
            pq.add(trips[i]);

        }

        return true;
        
        
    }
}