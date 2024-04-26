import java.util.*;

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        int length = intervals.size();
        if (length == 0 || length == 1) return true;

        // Sort the intervals based on the start time
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        });

        for(int i = 0; i < length - 1; i++){
            if(intervals.get(i).end > intervals.get(i+1).start)
                return false;
        }
        return true;
    }
}