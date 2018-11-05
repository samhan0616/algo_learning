package sort;

import java.util.Arrays;

/**
 * @author create by Xiao Han 10/22/18
 * @version 1.0
 * @since jdk 1.8
 */
public class hoare {
  public static void quicksort(int[] ar) {
    if (ar == null) return;
    quicksort(ar, 0, ar.length-1);
  }

  private static void quicksort(int[] ar, int lo, int hi) {
    if (lo < hi) {
      int splitPoint = partition(ar, lo, hi);
      quicksort(ar, lo, splitPoint);
      quicksort(ar, splitPoint+1, hi);
    }
  }

  private static int partition(int[] ar, int lo, int hi) {
    int pivot = ar[lo];
    int i = lo-1, j = hi+1;
    while(true) {
      do { i++; } while(ar[i] < pivot);
      do { j--; } while(ar[j] > pivot);
      if (i < j) swap(ar, i, j);
      else return j;
    }
  }

  private static void swap(int[] ar, int i, int j) {
    int tmp = ar[i];
    ar[i] = ar[j];
    ar[j] = tmp;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{13, 19, 9, 5, 12, 8, 7, 4, 11, 2, 6, 21};
    hoare.quicksort(arr);
    System.out.print(Arrays.toString(arr));
  }
}
