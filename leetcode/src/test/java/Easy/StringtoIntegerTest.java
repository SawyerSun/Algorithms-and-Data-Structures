package Easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author sunyue
 * @version 1.0    2017/1/3 10:19
 */
public class StringtoIntegerTest {
    private StringtoInteger clz;
    @Before
    public void setUp() throws Exception {
        clz = new StringtoInteger();
    }

    @Test
    public void myAtoi() throws Exception {
        Assert.assertEquals(0,clz.myAtoi(null));
        Assert.assertEquals(0,clz.myAtoi("  "));
        Assert.assertEquals(0,clz.myAtoi(""));
        Assert.assertEquals(0,clz.myAtoi("ab56"));
        Assert.assertEquals(-12,clz.myAtoi(" -12ab56"));
        Assert.assertEquals(Integer.MAX_VALUE,clz.myAtoi(" 132346541151"));
        Assert.assertEquals(Integer.MIN_VALUE,clz.myAtoi(" -132346541151"));
    }

}