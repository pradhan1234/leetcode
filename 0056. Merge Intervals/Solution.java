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