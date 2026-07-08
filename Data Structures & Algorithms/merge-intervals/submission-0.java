class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;

        Arrays.sort(intervals , (a , b)->{
            return a[0] - b[0];

        });

       List<int[]> mergedIntervals = new LinkedList<>();

       int i = 0 ;
       int j = 0;
       int n = intervals.length ;

       while(j < n){
        int currStart = intervals[i][0];
        int currEnd = intervals[i][1];
    

        while(j < n && intervals[j][0] <= currEnd){
            currEnd = Math.max(currEnd , intervals[j][1]);
            j++;
        }

        mergedIntervals.add(new int[]{currStart , currEnd});
        i = j;
        

       }

       int[][] mergedArr = new int[mergedIntervals.size()][2];
        i = 0;
       for(int in[] : mergedIntervals){
            mergedArr[i++] = in;
       }




        return mergedArr;
        
    }
}
