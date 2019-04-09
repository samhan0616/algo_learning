package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 第一次排好序后递归左边右边比
 * @author XiaoXiao
 *
 */
public class QuickSort {
//	public static void main(String[] args) {
//		int[] arr = new int[]{6,1 , 2,7 , 9 , 3 , 4 , 5, 10 , 8};
//		quickSort(arr,  0, arr.length-1);
//		System.out.println(Arrays.toString(arr));
//		arr = new int[]{6,1 , 2,7 , 9 , 3 , 4 , 5, 10 , 8};
//		System.out.println(findKth(arr, 0, arr.length-1, 10));
//	}

	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			//先找到中间的位置
			int key = partition(arr, left, right);
			quickSort(arr,left, key - 1);
			quickSort(arr,key + 1, right);
		}
	}
	//找到中间位置
	public static int firstRound(int[] arr, int left, int right) {
		int l = left + 1;
		int r = right;
		int key = arr[left];
		while(l < r) {
			//从右往左找
			while(l < r && arr[r] > key) {
				r --;
			}
			//从左往右找
			while(l < r && arr[l] < key) {
				l++ ;
			}
			if(l < r) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
			}
		}
		arr[left] = arr[r];
		arr[r] = key;
		return r;
	}
	/**
	 * 变种：
	 * 找到第k大数字
	 * @param arr
	 * @param left
	 * @param right
	 * @param k
	 * @return
	 */
	private static int findKth(int[] arr, int left, int right, int k) {
		int key = -1;
		if (left < right) {
			//先找到中间的位置
			key = firstRound(arr, left, right);
			//检查第k大
			if ( key == k) {
				return arr[k];
			//如果key + 1 > k 说明在右半边
			} else if (key + 1 > k) {
				findKth(arr,key + 1, right, k);

			} else {
				findKth(arr,left, key - 1, k);
			}
		}
		System.out.println(arr.length);
		return arr[arr.length - k];
	}

  /**
   * 快排分类
   * @param a
   */
	public static int partition(int[] a) {
	  return partition(a, 0, a.length - 1);
    }


    public static int randomSele(int[] a, int left , int right, int i) {
	  if (left > right) {
	    return 0;
      }
	  if (left == right) {
	    return a[left];
      }

      int k = randomPartition(a, left, right);
	  int target = k - left + 1;
	  if (i == target) {
	    return a[k];
      } else if (i > target) {
	    return randomSele(a, k + 1, right, i - target);
      } else {
	    return randomSele(a, left, k - 1, i);
      }


    }

    public static int randomPartition(int[] a, int left, int right) {
	  System.out.println(left + " " + right);
	  int i = new Random().nextInt(right - left) + left;
	  swap(a, i, right);
	  return partition(a, left, right);
    }

  public static int partition(int[] a, int left, int right) {

    int i = left, j = right, pivot = a[j];
    while (i < j)
    	if (a[i++] > pivot) swap(a, --i, --j);
    swap(a, i , right);
    return i;
  }

	static int HoarePartition (int a[],int p, int r)
	{
		int x=a[p],i=p-1,j=r+1;
		while (true)
		{
			do {
				j--;
			}while(j >= 0 && a[j] <= x );

			do {
				i++;
			} while (i < a.length && a[i] >= x);

			if  (i < j) {
				swap(a, i, j);
			}
			else return j;
		}
	}


	public static void quickSort2(int[] arr, int left, int right) {
		if (left < right) {
			//先找到中间的位置
			int key = HoarePartition(arr, left, right);
			quickSort2(arr,left, key);
			quickSort2(arr,key + 1, right);
		}
	}





  public static void main(String[] args) {
    int [] arr = new int[]{13,19,9,5,12,8,7,4,11,2,6,21};
//    partition(arr);
//    System.out.println(Arrays.toString(arr));
//    quickSort(arr, 0, arr.length - 1);
//    System.out.println(Arrays.toString(arr));
	  quickSort(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
  }

  public static void swap(int [] a, int x, int y) {
    int temp = a[x];
    System.out.println(x + " " + y);
    a[x] = a[y];
    a[y] = temp;
  }
}
