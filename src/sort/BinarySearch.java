package sort;

import java.util.Arrays;

public class BinarySearch {



  /**
   * 传统binary search
   * @param arr
   * @param k
   * @return
   */
  public static int binarySearch(int[] arr, int k) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
      int m = (left + right) / 2;
      if (k == arr[m]) {
        return m;
      } else if (k > arr[m]) {
        left = m + 1;
      } else {
        right = m - 1;
      }
    }
    return -1;
  }

  /**
   * 递归版
   * @param arr
   * @param left
   * @param right
   * @param k
   * @return
   */
  public static int binarySearchRec(int[] arr, int left, int right, int k) {
    if (left < right) {
      int mid = (left + right) / 2;
      if (arr[mid] == k) {
        return mid;
      } else if (k > arr[mid]) {
        binarySearchRec(arr, mid + 1, right,k);
      } else {
        binarySearchRec(arr, left, mid -1, k);
      }
    }
    return -1;
  }

//  public static double findKthFrom2Arr(int[] arr1, int[] arr2, int k) {
//    int m = arr1.length;
//    int n = arr2.length;
//    if ((m+n) % 2 == 1) {
//      return findKth(arr1, 0, arr1.length, arr2,0, arr2.length, k + 1);
//    } else {
//      return (findKth(arr1, 0, arr1.length, arr2,0, arr2.length, k)
//              + findKth(arr1, 0, arr1.length, arr2,0, arr2.length, k + 1)) / 2.0;
//    }
//  }

//  public static int findKth(int[] arr1, int a1l, int a1r, int[] arr2, int a2l, int a2r, int k) {
//    int m = a1r - a1l;
//    int n = a2r - a2l;
//    if (m > n) {
//      return findKth(arr2, a2l, a2r, arr1, a1l, a1r, k);
//    } else if (m == 0) {
//      return arr1[k - 1];
//    } else if (k == 1) {
//      return Math.min(arr1[a1l], arr2[a2l]);
//    }
//
//
//    int mid = Math.min(k/2, m);
//    int pa = a1l + mid;
//    int pb = a1l + a2l + k - mid;
//
//    if (arr1[pa - 1] < arr2[pb - 1]) {
//      return findKth(arr1, pa, a1r, arr2, a2l, a2r, k - pa + a1l);
//    } else if(arr1[pa - 1] > arr2[pb - 1]){
//      return findKth(arr1, a1l, a1r, arr2, pb, a2r, k - pb + a2l);
//    } else {
//      return arr1[pa - 1];
//    }
//
//  }

  static int findLastOne(int[]a, int i) {
    int l = 0;
    int r = a.length - 1;
    while(l < r -1) {
      int mid = (l + r) /2;
      if (a[mid] > i) {
        r = mid - 1;
      } else if ( a[mid] == i){
        l = mid;
      } else {
        l = mid + 1;
      }
    }
    return r;
  }


  public static double  findMedianSortedArrays(int[] nums1, int[] nums2) {
    int length1 = nums1.length;
    int length2 = nums2.length;
    int k = (length1 + length2) / 2;

    if((length1 + length2) % 2 == 1) {
      return findKth2(nums1, 0,length1, nums2, 0, length2, k + 1);
    } else {
      int result = findKth2(nums1, 0,length1, nums2, 0, length2, k)
              + findKth2(nums1, 0,length1, nums2, 0, length2, k+ 1);
      return  result / 2.0;
               //return findKth2(nums1, 0,length1, nums2, 0, length2, k+ 1);// / 2;
    }
  }

  public static int findKth2(int[] a, int start1, int length1, int[] b, int start2, int length2, int k) {
    int m = length1 - start1;
    int n = length2 - start2;
    if (m > n) {
      return findKth2(b, start2, length2, a, start1, length1,k);
    } else if (m == 0) {
      return b[k - 1];
    } else if (k == 1) {
      return Math.min(a[start1], b[start2]);
    }

    int mid = Math.min(k/2, m);
    int pm = start1 + mid;
    int pn = start1 + start2 + k - pm;

    if(a[pm - 1] < b[pn - 1]) {
      return findKth2(a, pm, length1, b, start2,length2, k - pm + start1);
    } else if(a[pm-1] > b[pn-1]) {
      return findKth2(a, start1, length1, b, pn, length2, k - pn + start2);
    } else {
      return a[pm - 1];
    }
  }

  public static int booleanArr(boolean[] a) {
    int l = 0, r = a.length - 1;
    while (l < r - 1) {
      int mid = (l + r) / 2;
      if(a[mid]) {
        l = mid;
      } else {
        r = mid;
      }
    }
    return l;
  }

  public static int removeDuplicates(int[] nums) {
    int res = 1;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      int last = findLastOne2(nums, num);
      if (last == nums.length - 1 ) {
        return res;
      } else if (last != i){
//        nums[res] = nums[last + 1];
        i = last;
      }
      nums[res] = nums[last + 1];
      res ++;
    }
    return res;
  }

  static void swap(int[] a, int m, int n) {
    int temp = a[m];
    a[m] = a[n];
    a[n] = temp;
  }
  static int findLastOne2(int[]a, int i) {
    int l = 0;
    int r = a.length - 1;
    while(l < r) {
      int mid = (l +  1 + r) /2;
      if (a[mid] <= i) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    return r ;
  }

  public static void main(String[] args) {
//    int[] arr = new int[] {-1,0,3,5,9,12};
//    int[] arr2 = new int[] {2,4,6,8};
//    System.out.println(binarySearch(arr, 9));
//    System.out.println(binarySearchRec(arr, 0, arr.length,5));
//    arr = new int[] {1 , 2};
//    arr2 = new int[] {-1 , 3};
//    System.out.println(findMedianSortedArrays(arr,arr2));
//
//    boolean[] ba = new boolean[] {true,false,true,false};
//    System.out.println(booleanArr(ba));
    int[] a = new int[]{1,1,1,1,2,3,4,4,4,4};
 //   System.out.println(findLastOne2(a, 1));
    System.out.println(removeDuplicates(a));
    System.out.println(Arrays.toString(a));
  }
}
