package struct.heap;

import sort.SortUtil;

import java.util.Arrays;

/**
 * @author create by Xiao Han 10/8/18
 * @version 1.0
 * @since jdk 1.8
 */
public class HeapSort {

  public void sort (int[] arr) {
    int len = arr.length;
    for (int i = len / 2 - 1; i >= 0; i --) {
      maxHeapify(arr, i);
    }
  }

  public void maxHeapify(int[] arr, int i) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int len = arr.length;
    int largest = 0;
    if (left < len && arr[left] > arr[i]) {
      largest = left;
    } else {
      largest = i;
    }
    if (right < len && arr[right] > arr[largest]) {
      largest = right;
    }
    if (largest != i) {
      SortUtil.swap(arr, largest , i);
      maxHeapify(arr, largest);
    }
  }


  // Driver program
  public static void main(String args[])
  {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int n = arr.length;

    HeapSort ob = new HeapSort();
    ob.sort(arr);

    System.out.println("Sorted array is");
    SortUtil.printArr(arr);
  }
}