package sort;

import java.util.Arrays;

public class SortUtil {
	public static void main(String[] args) {

		int n[] = new int[]{1,4,2,3,4,6,5,2,1,1};
		sort(n);
		System.out.println(Arrays.toString(n));
	}
	static void sort(int[] nums){
		for(int i = nums.length - 1; i > 0; i--) { 
			if(nums[i] > nums[i - 1]) { 
				for(int j = nums.length - 1; j >= i; j--) 
					if(nums[j] > nums[i - 1]) { 
						swap(nums,i - 1, j);
						break; 
						} 
				for(int j = 0; j < (nums.length - i) / 2; j++) 
					swap(nums , i + j, nums.length - j - 1); 
					return ;
				} 
		}
	
		for(int j = 0; j < nums.length / 2; j++) {
			swap(nums, j, nums.length - j - 1);
		}

	}
	static void swap(int[]nums, int i, int j){
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[j] ^ nums[i];
		nums[i] = nums[i] ^ nums[j];
	}
	public static void printArr(int[] arr){
		System.out.print("[ ");
		for (int i : arr) {
			System.out.print( i + ", ");
		}
		System.out.println("]");
	}
}
