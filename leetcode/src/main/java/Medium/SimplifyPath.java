package Medium;

import java.util.*;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * <p>
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 *
 * @author sunyue
 * @version 1.0    2017/7/16 9:49
 */
public class SimplifyPath {
    /**
     * Stack Solution
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * Runtime: 16 ms
     */
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        StringBuilder res = new StringBuilder();
        for (String dir : stack) {
            res.insert(0, dir).insert(0, "/");
        }
        return res.length() == 0 ? "/" : res.toString();
    }
}
