package sort;

import java.util.Arrays;

/**
 * 第一次排好序后递归左边右边比
 * @author XiaoXiao
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arr = new int[]{6,1 , 2,7 , 9 , 3 , 4 , 5, 10 , 8};
		quickSort(arr,  0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		arr = new int[]{6,1 , 2,7 , 9 , 3 , 4 , 5, 10 , 8};
		System.out.println(findKth(arr, 0, arr.length-1, 10));
	}

	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			//先找到中间的位置
			int key = firstRound(arr, left, right);
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
	
}
