package Medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18]
 *
 * @author sunyue
 * @version 1.0    2017/6/26 19:26
 */
public class MergeIntervals {
    /**
     * 根据start排序，若cur.start<pre.end，则merge这两个区间
     * 时间复杂度: O(n log n)
     * 空间复杂度: O(1)
     * 运行时间: 98 ms
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;

        intervals.sort(Comparator.comparingInt(i -> i.start));

        List<Interval> res = new ArrayList<>();
        Interval pre = intervals.get(0);

        for (Interval cur : intervals) {
            if (cur.start <= pre.end) {
                pre.end = Math.max(cur.end, pre.end);
            } else {
                res.add(pre);
                pre = cur;
            }
        }
        res.add(new Interval(pre.start, pre.end));
        return res;
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
