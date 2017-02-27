package three;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author sunyue
 * @version 1.0    2017/1/13 11:09
 */
public class PointTest {
    private Point[] points;

    @Before
    public void setUp() {
        points = new Point[4];
        points[0] = new Point(0, 0);
        points[1] = new Point(1, 0);
        points[2] = new Point(0, 1);
        points[3] = new Point(1, 1);
    }

    @Test
    public void test() {
        Assert.assertEquals(-1, points[0].compareTo(points[1]));
        Assert.assertEquals(-1, points[0].compareTo(points[2]));
        Assert.assertEquals(0, points[0].compareTo(points[0]));
        Assert.assertEquals(Double.NEGATIVE_INFINITY, points[0].slopeTo(points[0]), 0);
        Assert.assertEquals(0, points[0].slopeTo(points[1]), 0);
        Assert.assertEquals(Double.POSITIVE_INFINITY, points[0].slopeTo(points[2]), 0);
        Assert.assertEquals(1, points[0].slopeTo(points[3]), 0);
    }

    @Test
    public void testOrder() {
        Arrays.sort(points, points[3].slopeOrder());
        for (int j = 0; j < points.length; j++) {
            System.out.println(points[j]);
        }
        System.out.println();

    }

    @Test
    public void testSlopeTo() {
        Point p = new Point(106, 275);
        Point q = new Point(349, 104);
        Assert.assertEquals(-0.7037037037037037, p.slopeTo(q), 0);
    }

    @Test
    public void testCompareTo() {
        Point p = new Point(0, 6);
        Point q = new Point(3, 8);
        Point r = new Point(6, 7);
        Assert.assertEquals(1, p.slopeOrder().compare(q, r));
    }
}