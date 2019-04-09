package sort;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[] {5,4,1,2,3};
		sort(arr, 0, arr.length - 1);
	}
	
	public static void sort(int[] arr, int left, int right) {
		int mid = (right + left) / 2;
		if (left < right) {

			sort(arr, left, mid);
			//分右边
			sort(arr, mid+1, right);
			//合并
			merge(arr, left, right);
		}
	}
	
	public static void merge (int[] arr, int left, int right) {
		int mid = (right + left) / 2;
		int[] temp = new int[right - left + 1];
		int count = 0;

		int l = left;
		int r = mid + 1;
		
		while(l <= mid && r <= right) {
			if (arr[l] < arr[r]) {
				temp[count++] = arr[l++];
			} else {
				temp[count++] = arr[r++];
			}
		}
		
		while(l <= mid) {
			temp[count++] = arr[l++];
		}
		while(r <= right) {
			temp[count++] = arr[r++];
		}
		//write back
		for(int i = 0; i < temp.length; i++) {
			arr[left + i] = temp[i];
		}
	}





  }

