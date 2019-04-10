package leetcode.leetcode_51_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class Lc56_Merge_Intervals {

    /**
     * compare and modify the last inserted element
     * @param intervals
     * @return
     */
    public List<Interval> merge1(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);

        Interval prev = null;
        for (Interval inter : intervals) {
            if (prev == null || inter.start > prev.end) {
                res.add(inter);
                prev = inter;
            } else if (inter.end > prev.end) {
                // Modify the element already in list
                prev.end = inter.end;
            }
        }
        return res;
    }

    /**
     * get first start and end, compare the end until there is one
     * interval not overlapped. then create a new interval.
     * @param intervals
     * @return
     */
    public List<Interval> merge2(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }





    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
