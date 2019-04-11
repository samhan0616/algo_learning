package leetcode.leetcode_51_100;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
public class Lc69_Sqrt {
    /**
     * Binary search
     * lo to hi is 1....x
     * find the mid and see if mid ^ 2 > x
     * then make mid smaller, vase versa
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 1, right = x;
        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            if (mid < (x / mid)  && (mid + 1) > x / (mid + 1)) return mid;
            if (mid < x / mid) left = mid;
            else right = mid;
        }
        return (left * left < x && (left + 1) * (left + 1) > x) ? left : right;

    }
}
