package Easy;

/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x.
 *
 * @author sunyue
 * @version 1.0    2017/7/13 22:19
 */
public class Sqrt {
    /**
     * Binary Search
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * Runtime: 3 ms
     */
    public int mySqrt(int x) {
        if (0 == x) return 0;
        int low = 1;
        int high = x;
        int res = 0;
        while (low <= high) {
            // Attention : + has precedence over >>
            int mid = low + ((high - low) >> 2);
            // int mid = low + (high-low) / 2;
            if (mid <= x / mid) {
                low = mid + 1;
                res = mid;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    /**
     * Newton Method
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * Runtime: 2 ms
     */
    public int mySqrt2(int x) {
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }
}
