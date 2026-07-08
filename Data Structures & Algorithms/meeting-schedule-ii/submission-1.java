/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() <= 1)return intervals.size();

        int n = intervals.size();
        int startTime[] = new int[n];
        int endTime[] = new int[n];

        int k = 0;
        for(Interval i : intervals){
            startTime[k] = i.start;
            endTime[k] = i.end;
            k++;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int i = 0;
        int j = 0;

        int count = 0;
        int maxRooms = 0;

        while(i<startTime.length && j < endTime.length){
            
            if(startTime[i] < endTime[j]){
                count++;
                maxRooms = Math.max(maxRooms , count);
                i++;
            }else{
                count--;
                j++;

            }


        }
        return maxRooms;

    }
}
