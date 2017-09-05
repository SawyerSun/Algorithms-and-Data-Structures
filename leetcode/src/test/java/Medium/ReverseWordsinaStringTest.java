package Medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author sunyue
 * @version 1.0
 * @createOn 2017/9/5 22:45
 */
public class ReverseWordsinaStringTest {
    private ReverseWordsinaString r;

    @Before
    public void setUp() throws Exception {
        r = new ReverseWordsinaString();
    }

    @Test
    public void reverseWords() throws Exception {
        Assert.assertEquals("", r.reverseWords(" "));
        Assert.assertEquals("h www bca", r.reverseWords(" bca www h"));
        Assert.assertEquals("h www h hh", r.reverseWords("hh h www h "));

    }

}