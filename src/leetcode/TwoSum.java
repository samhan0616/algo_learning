package leetcode;

import sort.MergeSort;

import java.util.Arrays;

public class TwoSum {

  public static void main(String[] args) {
    int[] arr = new int[] {5,4,1,2,3};
    System.out.println(Arrays.toString(twoSumBinary(arr, 3)));
  }

  public static int[] twoSumBinary(int arr[], int target) {
    MergeSort.sort(arr, 0 , arr.length -1);
    for (int i = 0 ; i < arr.length; i ++) {
      int index;
     if ((index = Arrays.binarySearch(arr, i, arr.length, target - arr[i])) > 0) {
       return new int[] {arr[i] , arr[index]};

     }
    }
    return null;
  }
}
