package Hard;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 * <p>
 * Tags: Binary Search, Array, Divide and Conquer
 *
 * @author sunyue
 * @version 1.0    2017/1/2 13:38
 */
public class MedianofTwoSortedArrays {
    /**
     * 暴力方法，使用新数组int[m+n]来保存排序结果，时间复杂度不满足要求！
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(m + n)
     * Leetcode运行时间：66 ms
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, i = 0, j = 0, index = 0;
        double mid = 0;
        int[] res = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[index++] = nums1[i++];
            } else {
                res[index++] = nums2[j++];
            }
        }
        while (i < m) {
            res[index++] = nums1[i++];
        }
        while (j < n) {
            res[index++] = nums2[j++];
        }
        mid = (m + n) % 2 == 1 ? res[(m + n) / 2] : (res[(m + n) / 2 - 1] + res[(m + n) / 2]) / 2.0;
        return mid;
    }

    /**
     * 递归二分搜索，构造一个help函数用于找到两个数组中第K个数，对第(m + n + 1) / 2和(m + n + 2) / 2个数取中值，便得到结果。
     * help函数getKth使用地柜二分搜索，详细说明见下面注释。
     * 时间复杂度：O(log(m + n))
     * 空间复杂度：O(1)
     * Leetcode运行时间：66 ms
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, l = (m + n + 1) / 2, r = (m + n + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    private double getKth(int[] A, int aStart, int[] B, int bStart, int k) {
        // A已经遍历结束，返回B中第K个
        if (aStart > A.length - 1) {
            return B[bStart + k - 1];
        }
        // B已经遍历结束，返回A中第K个
        if (bStart > B.length - 1) {
            return A[aStart + k - 1];
        }
        // k为1，返回AB中小的第1个
        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }

        // 标记出AB中值
        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k / 2 - 1 < A.length) {
            aMid = A[aStart + k / 2 - 1];
        }
        if (bStart + k / 2 - 1 < B.length) {
            bMid = B[bStart + k / 2 - 1];
        }
        // 递归二分查找
        if (aMid < bMid) {
            // 检查aRight+bLeft
            return getKth(A, aStart + k / 2, B, bStart, k - k / 2);
        } else {
            // // 检查bRight+aLeft
            return getKth(A, aStart, B, bStart + k / 2, k - k / 2);
        }
    }

    /**
     * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation
     * 时间复杂度：O(log(m + n))
     * 空间复杂度：O(1)
     * Leetcode运行时间：5 ms
     */
    public double findMedianSortedArrays3(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if (m > n) {
            return findMedianSortedArrays1(B, A);
        }

        int imin = 0, imax = m, half_len = (m + n + 1) / 2;
        int max_of_left = 0, min_of_right = 0;
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = half_len - i;

            if (j > 0 && i < m && B[j - 1] > A[i]) {
                // i太小
                imin = i + 1;
            } else if (i > 0 && j < n && A[i - 1] > B[j]) {
                // i太大
                imax = i - 1;
            } else {
                // i正好
                if (i == 0) {
                    max_of_left = B[j - 1];
                } else if (j == 0) {
                    max_of_left = A[i - 1];
                } else {
                    max_of_left = Math.max(A[i - 1], B[j - 1]);
                }

                if ((m + n) % 2 == 1) {
                    return max_of_left;
                }

                if (i == m) {
                    min_of_right = B[j];
                } else if (j == n) {
                    min_of_right = A[i];
                } else {
                    min_of_right = Math.min(A[i], B[j]);
                }
                return (double) (max_of_left + min_of_right) / 2.0;
            }
        }
        return 0;
    }
}
