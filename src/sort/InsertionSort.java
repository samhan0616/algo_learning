package sort;

import java.util.Arrays;

public class InsertionSort {
  public static void main(String[] args) {
      int[] arr = new int[]{31,41,59,26,41,58};
      recursiveSort(arr, arr.length);
      System.out.println(Arrays.toString(arr));
  }

  /**
   * 正常的插入排序
   * @param arr
   */
  public static void sort(int[] arr){
      //start
      int length = arr.length;
      for(int i = 1; i < length; i++) {
          int curr = arr[i];
          int posi = i - 1;
          while(posi >= 0 && arr[posi] > curr) {
              arr[posi + 1] = arr[posi--];
          }
          arr[posi + 1] = curr;
      }
  }

  /**
   * 插入排序 递归版
   */
  private static void recursiveSort(int[] arr, int length) {
    if (length > 1) {
      recursiveSort(arr, length - 1);
      insert(arr, length);
    }
  }

  private static void insert(int[] arr, int length) {
    if (length != 1) {
      int key = arr[length - 1];
      int count = length - 2;

      while (count >= 0 && arr[count] > key) {
        arr[count + 1] = arr[count --];
      }
      arr[count + 1] = key;
    }
  }

  /**
   * 插入排序 二分查找版
   * @param arr
   */
  private static void sortBinarySearch(int[] arr) {
    for (int i = 1; i < arr.length; i ++) {
      int key = arr[i];
      int index = binarySearch(arr, i, key);
      for (int j = i - 1; j >= index; j--) {
        arr[j + 1] = arr[j];
      }
      arr[index] = key;
    }
  }

  /**
   * 二分查找
   * @param arr
   * @param end
   * @param key
   * @return
   */
  private static int binarySearch(int[] arr, int end, int key) {
    int l = 0, r = end;
    while (l < r) {
      int mid = (r + l)/ 2;
      if (arr[mid] < key) {
        l = mid + 1;
      }else {
        r = mid - 1;
      }
    }
    if (key <= arr[l]) {
      return  l;
    } else {
      return l + 1;
    }

  }
}
	
	
	
	
	
	
	

