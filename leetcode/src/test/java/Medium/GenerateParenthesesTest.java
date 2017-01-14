package Medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author sunyue
 * @version 1.0    2017/1/14 14:19
 */
public class GenerateParenthesesTest {
    private  GenerateParentheses clz;

    @Before
    public void setUp() throws Exception {
        clz = new GenerateParentheses();
    }

    @Test
    public void test() throws Exception{
        List<String> list = clz.generateParenthesis(3);
        Assert.assertEquals(5,list.size());
    }

}