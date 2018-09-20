package sort;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[] {5,4,1,2,3};
		sort3(arr, 0, arr.length - 1);
	}
	
	public static void sort(int[] arr, int left, int right) {
		int mid = (right + left) / 2;
		if (left < right) {
			//分左边
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
	/**
	 * 2018年9月5日09:07:04
	 * @param arr
	 * @param left
	 * @param right
	 */
	public static void sort2(int[] arr, int left, int right){
		int mid = (left + right) / 2;
		if (left < right) {
			sort2(arr, left, mid);
			sort2(arr, mid + 1, right);
			merge2(arr, left, right);
			SortUtil.printArr(arr);
		}
	}	
	public static void merge2(int[] arr, int left, int right) {
		int mid = (left + right) / 2;
		int[] temp = new int[right - left + 1];
		int count = 0;
		
		int l = left;
		int r = mid + 1;
		
		while (l <= mid && r <= right) {
			if(arr[l] < arr[r]) {
				temp[count++] = arr[l++];
			} else {
				temp[count++] = arr[r++];
			}
		}
		
		while (l <= mid) {
			temp[count++] = arr[l++];
		}
		while (r <= right) {
			temp[count++] = arr[r++];
		}
		
		//write back
		for(int i = 0; i < temp.length; i++) {
			arr[left + i] = temp[i];
		}
	}
	/**
	 * 2018年9月15日10:19:23
	 * @param arr
	 * @param left
	 * @param right
	 */
	private static void sort3(int[] arr, int left, int right) {
		int mid = (left + right) / 2;
		if(left < right) {
			sort3(arr, left, mid);
			sort3(arr, mid + 1, right);
			merge3(arr, left, right);
			SortUtil.printArr(arr);
		}
	}
	
	private static void merge3(int [] arr, int left, int right) {
		
		int mid = (left + right) / 2;
		int l = left;
		int r = mid + 1;
		int[] temp = new int[right - left + 1];
		int count = 0;
		while(l <= mid && r <= right) {
			if(arr[l] < arr[r]) {
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
		//merge
		for(int i = 0; i < temp.length; i++) {
			arr[left + i] = temp[i];
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
