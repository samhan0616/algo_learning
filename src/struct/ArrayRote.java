package struct;

import java.util.HashMap;

public class ArrayRote{
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7};
		rotate(arr, 3);
	}
	public static void rotate(int[] nums, int k) {
	       if (nums.length != 0 && k >= 0) {
	            k = k % nums.length;
	            reverse(nums, 0, nums.length - 1);
	            reverse(nums, 0, k - 1);
	            reverse(nums, k, nums.length - 1);
	        }
	    }

	    public static void reverse(int[] nums, int start, int end) {
	        while (start < end) {

	            int tmp = nums[end];
	            nums[end] = nums[start];
	            nums[start] = tmp;

	            start++;
	            end--;
	        }
	    }
}