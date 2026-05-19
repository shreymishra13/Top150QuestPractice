class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> kClosestPoints = new PriorityQueue<>(
            (a , b)->{
                int dist1 = (a[0]*a[0]  + a[1]*a[1]);
                int dist2 = (b[0]*b[0]  + b[1]*b[1]);

                return Integer.compare(dist2,dist1);
            }
        );

        for(int point[] : points){
            kClosestPoints.add(point);
            if(kClosestPoints.size()>k)kClosestPoints.remove();

        }

        int i = 0;
        int answer[][] = new int[kClosestPoints.size()][2];
        while(!kClosestPoints.isEmpty()){
            answer[i] = kClosestPoints.remove();
            i++;
        }
        return answer;

    }
}
