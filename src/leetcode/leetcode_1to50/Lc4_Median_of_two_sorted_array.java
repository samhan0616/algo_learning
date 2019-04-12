package leetcode.leetcode_1to50;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class Lc4_Median_of_two_sorted_array {
    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return calculate(nums1, 0, nums2, 0, len / 2 + 1);
        } else {
            return (calculate(nums1, 0, nums2, 0, len / 2 + 1) + calculate(nums1, 0, nums2, 0, len / 2)) / 2.0;
        }
    }

    double calculate(int[] n1, int l1, int[] n2, int l2, int len) {
        if (n1.length == l1) return n2[l2 + len - 1];
        if (n2.length == l2) return n1[l1 + len - 1];
        if (len == 1) return Math.min(n1[l1], n2[l2]);

        int v1 = l1 + len / 2 - 1 >= n1.length ? Integer.MAX_VALUE : n1[l1 + len / 2 -1];
        int v2 = l2 + len / 2 - 1 >= n2.length ? Integer.MAX_VALUE : n2[l2 + len / 2 -1];
        if (v1 < v2) {
            return calculate(n1, l1 + len / 2, n2, l2, len - len / 2);
        } else {
            return calculate(n1, l1, n2, l2 + len / 2, len - len / 2);
        }
    }
}
