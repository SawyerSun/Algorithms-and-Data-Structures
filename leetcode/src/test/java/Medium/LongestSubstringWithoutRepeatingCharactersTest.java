package Medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author sunyue
 * @version 1.0    2017/1/1 22:31
 */
public class LongestSubstringWithoutRepeatingCharactersTest {
    private LongestSubstringWithoutRepeatingCharacters testClass;
    private String testString = "pwwkew";

    @Before
    public void setup() {
        testClass = new LongestSubstringWithoutRepeatingCharacters();

    }

    @Test
    public void lengthOfLongestSubstring1() throws Exception {

    }

    @Test
    public void lengthOfLongestSubstring2() throws Exception {

    }

    @Test
    public void lengthOfLongestSubstring3() throws Exception {
        int res = testClass.lengthOfLongestSubstring3(testString);
        Assert.assertEquals(3, res);
    }

}