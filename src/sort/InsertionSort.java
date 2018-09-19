package sort;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = new int[]{31,41,59,26,41,58};
		sort3(arr);
		SortUtil.printArr(arr);
	}
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
	
	/*
	 * 2018年9月5日08:24:59
	 */
	public static void sort2(int[] arr) {
		int length = arr.length;
		
		for(int i = 1; i < length; i++) {
			int curr = arr[i];
			int posi = i - 1;
			while(posi >= 0 && curr < arr[posi]){
				arr[posi + 1] = arr[posi--];
			}
			arr[posi + 1] = curr;
		}
	}
	
	/**
	 * 2018年9月15日10:06:34
	 * @param arr
	 */
	private static void sort3(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int curr = i - 1;
			while(curr >= 0 && arr[curr] > key) {
				arr[curr + 1] = arr[curr--];
			}
			arr[curr + 1] = key;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
