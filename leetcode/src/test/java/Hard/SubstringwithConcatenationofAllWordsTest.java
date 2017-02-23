package Hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author sunyue
 * @version 1.0    2017/2/23 11:06
 */
public class SubstringwithConcatenationofAllWordsTest {
    private SubstringwithConcatenationofAllWords clz;

    @Before
    public void setUp() throws Exception {
        clz = new SubstringwithConcatenationofAllWords();
    }

    @Test
    public void findSubstring() throws Exception {
        String[] words = new String[]{"word", "good", "best", "good"};
        List<Integer> res = clz.findSubstring("wordgoodgoodgoodbestword", words);
        Assert.assertEquals(8, (int) res.get(0));
    }

    @Test
    public void findSubstring2() throws Exception {
        String[] words = new String[]{"word", "good", "best", "good"};
        List<Integer> res = clz.findSubstring2("wordgoodgoodgoodbestword", words);
        Assert.assertEquals(8, (int) res.get(0));
    }

}