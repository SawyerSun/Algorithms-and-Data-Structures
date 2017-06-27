package Hard;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * <p>
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 * @author sunyue
 * @version 1.0    2017/6/27 20:03
 */
public class InsertInterval {
    /**
     * 由于已经有序，只要按顺序处理3种情况
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     * 运行时间：17ms
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        int i = 0;
        // 添加所有end比newInterval的begin小的
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }
        // merge重复的
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval(Math.min(newInterval.start, intervals.get(i).start), Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        res.add(newInterval);
        // 添加所有剩下的，即start比newInterval的end大的
        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }
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
