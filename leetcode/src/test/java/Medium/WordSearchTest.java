package Medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author sunyue
 * @version 1.0
 * @createOn 2017/9/5 22:08
 */
public class WordSearchTest {
    private WordSearch ws;

    @Before
    public void setUp() throws Exception {
        ws = new WordSearch();
    }

    @Test
    public void exist() throws Exception {
        char[][] board1 = new char[][]{{'A', 'B', 'C'}, {'D', 'N', 'B'}, {'F', 'G', 'A'}};
        char[][] board2 = new char[][]{{'A', 'B', 'C', 'V'}, {'D', 'N', 'B', 'G'}, {'F', 'G', 'A', 'T'}};
        Assert.assertEquals(true, ws.exist(board1, "ABNB"));
        Assert.assertEquals(false, ws.exist(board1, "BUBI"));
        Assert.assertEquals(true, ws.exist(board2, "CVGB"));
        Assert.assertEquals(false, ws.exist(board2, "ADSAFB"));
    }

}