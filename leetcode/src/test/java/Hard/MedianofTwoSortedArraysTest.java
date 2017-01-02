package Hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author sunyue
 * @version 1.0    2017/1/2 14:24
 */
public class MedianofTwoSortedArraysTest {
    private MedianofTwoSortedArrays testClass ;
    private int[] nums1;
    private int[] nums2;

    @Before
    public void setUp() throws Exception {
        testClass = new MedianofTwoSortedArrays();
        nums1 = new int[]{2,3,4};
        nums2 = new int[]{1};
    }

    @Test
    public void findMedianSortedArrays1() throws Exception {

    }

    @Test
    public void findMedianSortedArrays2() throws Exception {
        double res = testClass.findMedianSortedArrays2(nums1,nums2);
        Assert.assertEquals(2.5,res);
    }

    @Test
    public void findMedianSortedArrays3() throws Exception {

    }

}