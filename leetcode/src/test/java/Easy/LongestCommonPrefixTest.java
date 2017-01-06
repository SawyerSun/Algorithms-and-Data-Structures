package Easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author sunyue
 * @version 1.0    2017/1/6 16:30
 */
public class LongestCommonPrefixTest {
    private LongestCommonPrefix clz ;
    private String[] strs ;
    @Before
    public void setUp() throws Exception {
        clz = new LongestCommonPrefix();
        strs = new String[]{"leetcode","leet","leehhh"};
    }

    @Test
    public void longestCommonPrefix1() throws Exception {

    }

    @Test
    public void longestCommonPrefix2() throws Exception {

    }

    @Test
    public void longestCommonPrefix3() throws Exception {
        String prefix = clz.longestCommonPrefix3(strs);
        Assert.assertEquals("lee",prefix);
    }

    @Test
    public void longestCommonPrefix4() throws Exception {

    }

}