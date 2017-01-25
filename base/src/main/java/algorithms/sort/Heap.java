package algorithms.sort;

/**
 * 堆排序
 * @author sunyue
 * @version 1.0 2017/1/25 上午12:38
 */
public class Heap {
    public static void sort(Comparable[] a){
        int len = a.length;
        for (int i = len/2; i >=1 ; i--) {
            sink(a,i,len);
        }
        while (len>1){
            Util.exch(a,1,len);
            sink(a,1,--len);
        }
    }

    private static void sink(Comparable[] a,int k,int n){
        while (2*k<=n){
            int j = 2*k;
            if (j<n&&Util.less(a,j,j+1))j++;
            if (!Util.less(a,k,j))break;
            Util.exch(a,k,j);
            k = j;
        }
    }
}
