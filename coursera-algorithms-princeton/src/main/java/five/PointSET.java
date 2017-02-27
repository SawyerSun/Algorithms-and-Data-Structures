package five;

import edu.princeton.cs.algs4.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author sunyue
 * @version 1.0    2017/2/24 16:44
 */
public class PointSET {
    private Set<Point2D> set;

    /**
     * construct an empty set of points
     */
    public PointSET() {
        set = new TreeSet<>();
    }

    /**
     * is the set empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }


    /**
     * number of points in the set
     *
     * @return
     */
    public int size() {
        return set.size();
    }

    /**
     * add the point to the set (if it is not already in the set)
     * O(log n)
     *
     * @param p
     */
    public void insert(Point2D p) {
        if (null == p) throw new NullPointerException("Point is null!");
        set.add(p);
    }

    /**
     * does the set contain point p?
     * O(log n)
     *
     * @param p
     * @return
     */
    public boolean contains(Point2D p) {
        if (null == p) throw new NullPointerException("Point is null!");
        return set.contains(p);
    }

    /**
     * draw all points to standard draw
     */
    public void draw() {
        for (Point2D p : set) {
            StdDraw.point(p.x(), p.y());
        }
    }

    /**
     * all points that are inside the rectangle
     * O(n)
     *
     * @param rect
     * @return
     */
    public Iterable<Point2D> range(RectHV rect) {
        if (null == rect) throw new NullPointerException("rect is null!");
        Queue<Point2D> queue = new Queue<>();
        for (Point2D p : set) {
            if (rect.contains(p)) {
                queue.enqueue(p);
            }
        }
        return queue;
    }

    /**
     * a nearest neighbor in the set to point p; null if the set is empty
     * O(n)
     *
     * @param p
     * @return
     */
    public Point2D nearest(Point2D p) {
        if (null == p) throw new NullPointerException("Point is null!");
        double minDis = Double.MAX_VALUE;
        Point2D res = null;
        for (Point2D q : set) {
            double dis = q.distanceSquaredTo(p);
            if (dis < minDis) {
                minDis = dis;
                res = q;
            }
        }
        return res;
    }
}
