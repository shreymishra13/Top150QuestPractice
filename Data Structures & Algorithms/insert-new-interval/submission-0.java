class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> finalIntervals = new LinkedList<>();
        int i = 0;
        int n = intervals.length;
        // first insert all the lesser intervals
       while(i < n && intervals[i][1] < newInterval[0]){
            finalIntervals.add(intervals[i]);
            i++;
       }
       //now we found our common intervals
       int newStart = newInterval[0];
       int newEnd = newInterval[1];

       while(i <n && newEnd >= intervals[i][0]){
            newStart = Math.min(intervals[i][0] , newStart);
            newEnd = Math.max(intervals[i][1] , newEnd);
            i++;


       }
       finalIntervals.add(new int[]{newStart , newEnd});
       while(i<n){
        finalIntervals.add(intervals[i]);
        i++;
       }
       return finalIntervals.toArray(new int[finalIntervals.size()][]);
    }
}
