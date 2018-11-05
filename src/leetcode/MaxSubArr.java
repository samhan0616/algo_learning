package leetcode;

/**
 * Given an integer array nums, find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its sum.
 * @author create by Xiao Han 9/25/18
 * @version 1.0
 * @since jdk 1.8
 */
public class MaxSubArr {
  public static void main(String[] args) {
    int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(findMaxN3(arr));
    System.out.println(findMaxNlogN(arr, 0 , arr.length - 1));
  }

  /**
   * O(n^2)
   * @param A
   * @return
   */
  public static int findMaxN3(int[] A) {
    int length = A.length;
    int max = -1000;
    for (int i = 0; i < length; i++) {
      int sum = 0;
      for (int j = i; j < length; j++) {
        sum += A[j];
        max = Math.max(sum, max);
      }
    }
    return max;
  }

  public static int findMaxNlogN(int[] a, int left, int right) {
    if (left == right) {
      return a[left];
    } {
      int mid = (left + right) / 2;
      int leftMax = findMaxNlogN(a, left, mid);
      int rightMax = findMaxNlogN(a, mid + 1, right);
      int crossMax =findCrossMax(a,left,right);
      return Math.max(leftMax, Math.max(rightMax, crossMax));
    }
  }

  public static int findCrossMax(int[] a, int left, int right) {
    int lsum = 0,rsum = 0, lmax = -10000, rmax = -10000;
    int mid = (left + right) / 2;
    for (int i = mid; i >= left; i--) {
      lsum += a[i];
      lmax = Math.max(lmax, lsum);
    }
    for (int i = mid + 1; i <= right; i++) {
      rsum += a[i];
      rmax = Math.max(rmax, rsum);
    }
    return lmax + rmax;
  }
}
