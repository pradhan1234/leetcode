class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        // sort the intervals
        Arrays.sort(intervals, (a, b) -> a.start > b.start ? +1 : a.start < b.start ? -1 : 0);
        // verify each interval ends before next starts.
        for(int i = 0; i < intervals.length - 1; i++) {
            if(intervals[i].end > intervals[i+1].start) {
                return false;
            }
        }
        return true;
    }
}