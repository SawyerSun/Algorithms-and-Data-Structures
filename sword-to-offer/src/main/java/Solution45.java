/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * 不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。为了方便起见,你可以认为大小王是0。
 * 时间限制：1秒
 * 空间限制：32768K
 *
 * @author sunyue
 * @version 1.0    2017/5/3 20:58
 */
public class Solution45 {
    /**
     * 满足条件：
     * 1. max-min <5
     * 2. 除0外没有重复数字
     * 3. 数字长度为5
     * 运行时间：33ms
     * 占用内存：503k
     */
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) return false;

        int[] d = new int[14];
        // 0最多有4个
        d[0] = -5;
        int max = -1;
        int min = 14;
        for (int number : numbers) {
            d[number]++;
            if (number == 0) continue;
            // 出现除0外的重复
            if (d[number] > 1) return false;
            if (number > max) max = number;
            if (number < min) min = number;
        }

        return max - min < 5;
    }
}
