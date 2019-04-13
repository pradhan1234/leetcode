/***
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        // base cases
        if(intervals == null || intervals.size() == 0) {
            return new LinkedList<Interval>();
        }

        // sort the intervals, using custom comparator
        Collections.sort(intervals, (a, b) -> a.start > b.start ? +1 : a.start < b.start ? -1 : 0);

        List<Interval> result = new ArrayList<>();
        result.add(intervals.get(0));

        for(Interval i : intervals) {
            Interval last = result.get(result.size()-1);
            if(last.end < i.start) { // non overlapping, simply include
                result.add(i);
            } else { // choose the one that spans more
                last.end = Math.max(last.end, i.end);
            }
        }
        return result;
    }
}