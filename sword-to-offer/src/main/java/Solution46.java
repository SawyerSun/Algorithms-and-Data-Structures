/**
 * 首先,让小朋友们围成一个大圈。随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
 * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数。
 * 直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/3 21:10
 */
public class Solution46 {
    /**
     * 用数组来模拟环
     * 运行时间：147ms
     * 占用内存：629k
     */
    public int LastRemaining(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int[] circle = new int[n];
        // 指针用来遍历环
        int i = -1;
        // 记录已经包裹数的个数
        int step = 0;
        // 记录剩余个数
        int count = n;
        while (count > 0) {
            i++;
            if (i >= n) i = 0;
            if (circle[i] == -1) continue;
            step++;
            if (step == m) {
                circle[i] = -1;
                step = 0;
                count--;
            }
        }
        return i;
    }
}
