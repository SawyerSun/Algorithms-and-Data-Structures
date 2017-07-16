package Hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author sunyue
 * @version 1.0    2017/7/16 17:36
 */
public class EditDistanceTest {
    private EditDistance clz;

    @Before
    public void setUp() throws Exception {
        clz = new EditDistance();
    }

    @Test
    public void minDistance() throws Exception {
        Assert.assertEquals(1, clz.minDistance("hallo", "hello"));
        Assert.assertEquals(2, clz.minDistance("hlo", "hello"));
        Assert.assertEquals(1, clz.minDistance("hellod", "hello"));
        Assert.assertEquals(0, clz.minDistance("", ""));
        Assert.assertEquals(5, clz.minDistance("", "hello"));
        Assert.assertEquals(1, clz.minDistance("a", "h"));
    }

}