package Medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author sunyue
 * @version 1.0    2017/1/8 17:11
 */
public class LetterCombinationsofaPhoneNumberTest {
    private LetterCombinationsofaPhoneNumber clz;


    @Before
    public void setUp() throws Exception {
        clz = new LetterCombinationsofaPhoneNumber();
    }

    @Test
    public void letterCombinations() throws Exception {
        List<String> res = clz.letterCombinations("123");
        Assert.assertEquals(9, res.size());
    }

}