package five;

import edu.princeton.cs.algs4.*;

/**
 * @author sunyue
 * @version 1.0    2017/2/24 16:52
 */
public class KdTree {
    private static final RectHV CANVAS = new RectHV(0, 0, 1, 1);
    private Node root;
    private int count;

    /**
     * construct an empty set of points
     */
    public KdTree() {
        this.root = null;
        this.count = 0;
    }

    /**
     * is the set empty?
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }


    /**
     * number of points in the set
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * add the point to the set (if it is not already in the set)
     * O(log n)
     *
     * @param p
     */
    public void insert(Point2D p) {
        if (null == p) throw new NullPointerException("Point is null!");
        root = insert(p, root, true, CANVAS);
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
        return get(p, root) != null;
    }

    /**
     * draw all points to standard draw
     */
    public void draw() {
        draw(root);
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
        SET<Point2D> set = new SET<>();
        range(set, rect, root);
        return set;
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
        if (null == root) return null;
        Point2D retP = null;
        double min = Double.MAX_VALUE;
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        // 使用队列，而不是递归
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            double dis = p.distanceSquaredTo(x.p);
            if (dis < min) {
                retP = x.p;
                min = dis;
            }
            // 左子树不为空，且左子树矩形到查询点p的最近距离 小于 当前最小值
            if (null != x.left && x.left.rect.distanceSquaredTo(p) < min) {
                queue.enqueue(x.left);
            }
            // 右子树不为空，且右子树矩形到查询点p的最近距离 小于 当前最小值
            if (null != x.right && x.right.rect.distanceSquaredTo(p) < min) {
                queue.enqueue(x.right);
            }
        }
        return retP;
    }

    private Node insert(Point2D p, Node n, boolean coordinate, RectHV rect) {
        // 节点n为空
        if (null == n) {
            count++;
            return new Node(p, coordinate, rect);
        }
        // 要插入的点和节点中的点相同
        if (p.equals(n.p)) return n;
        // 要插入的点在该节点左边或者下边
        if (n.compareTo(p) > 0) {
            n.left = insert(p, n.left, !coordinate, childRect(n, true));
        } else {
            n.right = insert(p, n.right, !coordinate, childRect(n, false));
        }
        return n;
    }

    private RectHV childRect(Node n, boolean left) {
        RectHV rect;
        RectHV temp = n.rect;
        // 左子树
        if (left) {
            if (null != n.left) {
                return n.left.rect;
            }
            // x-coordinate 划分，生成左半边和下半边矩阵
            if (n.coordinate) {
                rect = new RectHV(temp.xmin(), temp.ymin(), n.p.x(), temp.ymax());
            } else {
                rect = new RectHV(temp.xmin(), temp.ymin(), temp.xmax(), n.p.y());
            }
        } else {
            if (null != n.right) {
                return n.right.rect;
            }
            if (n.coordinate) {
                rect = new RectHV(n.p.x(), temp.ymin(), temp.xmax(), temp.ymax());
            } else {
                rect = new RectHV(temp.xmin(), n.p.y(), temp.xmax(), temp.ymax());
            }
        }
        return rect;
    }

    private Node get(Point2D p, Node n) {
        if (null == n) {
            return null;
        }
        // p和n节点中点相同
        if (n.p.equals(p)) {
            return n;
        }
        // p在n节点的左边或下边
        if (n.compareTo(p) > 0) {
            return get(p, n.left);
        } else {
            return get(p, n.right);
        }
    }

    private void draw(Node n) {
        if (null == n) return;
        draw(n.left);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        n.p.draw();
        StdDraw.setPenRadius();
        if (n.coordinate) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(n.p.x(), n.rect.ymin(), n.p.x(), n.rect.ymax());
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(n.rect.xmin(), n.p.y(), n.rect.xmax(), n.p.y());
        }
        draw(n.right);
    }

    private void range(SET<Point2D> set, RectHV rect, Node n) {
        if (null == n || !n.rect.intersects(rect)) return;
        // 矩形块 在节点n左边或下边 有一部分
        boolean left = (n.coordinate && rect.xmin() < n.p.x()) || (!n.coordinate && rect.ymin() < n.p.y());
        // 矩形块 在节点n右边或上边 有一部分
        boolean right = (n.coordinate && rect.xmax() >= n.p.x() || (!n.coordinate && rect.ymax() >= n.p.y()));
        if (left) {
            range(set, rect, n.left);
        }
        if (rect.contains(n.p)) {
            set.add(n.p);
        }
        if (right) {
            range(set, rect, n.right);
        }
    }

    private static class Node {
        private Point2D p;
        private RectHV rect;
        private Node left;
        private Node right;
        /**
         * 节点坐标划分，true 为 x-coordinate, false 为 y-coordinate
         */
        private boolean coordinate;

        public Node(Point2D p, boolean coordinate, RectHV rect) {
            this.p = p;
            this.coordinate = coordinate;
            this.rect = rect;
        }

        public int compareTo(Point2D that) {
            if (coordinate) {
                if (this.p.x() < that.x()) return -1;
                if (this.p.x() > that.x()) return 1;
            } else {
                if (this.p.y() < that.y()) return -1;
                if (this.p.y() > that.y()) return 1;
            }
            return 0;
        }
    }
}
