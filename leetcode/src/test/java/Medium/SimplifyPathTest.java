package Medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author sunyue
 * @version 1.0    2017/7/16 10:25
 */
public class SimplifyPathTest {
    private SimplifyPath clz;

    @Before
    public void setUp() throws Exception {
        clz = new SimplifyPath();
    }


    @Test
    public void simplifyPath() throws Exception {
        Assert.assertEquals("/abc/...", clz.simplifyPath("/abc/..."));
        Assert.assertEquals("/", clz.simplifyPath("/../"));
        Assert.assertEquals("/c", clz.simplifyPath("/a/./b/../../c/"));
        Assert.assertEquals("/home/foo", clz.simplifyPath("/home//foo"));
    }

}