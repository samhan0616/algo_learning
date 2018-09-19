package laioffer;

import java.util.Arrays;

/**
 * 1. 递归调用自己，收敛的
 * F(n) = F(n-1) + F(n-2)
 * 时间复杂度 O(2^n) 二叉树
 * 空间复杂度O(n) 冯诺依曼体系
 * 
 * call stack(存储机制): 
 * global accessible resource
 * Usage: store the local information for each
 * recursion function
 * 
 * 2. Binary search
 *  
 * @author XiaoXiao
 *
 */
public class Class1 {
	
	/**
	 * 经典递归
	 * callstack 用来存递归中变量的值
	 */
	int fibo (int n ) {
		if ( n == 1 || n == 0) return n;
		return fibo(n-1) + fibo(n-2);
	}
	
	/**
	 * 如何计算a的b次方
	 * 二分求次方
	 */
	static int sqr (int a, int b) {
		if(a == 0 || a == 1 || b == 1) return a;
		if (b == 0) return 1;
		if (b % 2 == 0) 
			return sqr(a, b/2) * sqr(a, b/2);
		else 
			return a * sqr(a, b/2) * sqr(a, b/2);
	}
	
	
	/**
	 * Binary search
	 * what is binary search in the contxt of an array?
	 * 二分查找 一半一半的找
	 * 
	 * 可以不是sorted
	 */
	 static int classicSearch(int[] arr, int target) {
		 if (arr == null || arr.length == 0) return -1;
		 int left = 0;
		 int right = arr.length - 1;
		 while(left <= right) {
			 int mid = (left + right) / 2;
			 if(arr[mid] == target) return mid;
			 else if (arr[mid] < target) left = mid + 1;
			 else right = mid - 1; 
		 }
		 return -1;
	 }
	 /**
	  * 二维数组二分查找
	  * @param arr
	  * @param target
	  * @return
	  */
	 static int[] matrixSearch(int[][] arr, int target) {
		 //模拟成一个一维数组
		 int len = arr.length;
		 int wid = arr[0].length;
		 //中间值是
		 int left = 0;
		 int right = len * wid - 1;
		 
		 while (left <= right) {
			 int mid = (left + right) / 2;
			 if( arr[mid / wid][mid % wid] == target) return new int[] {mid / wid, mid % wid};
			 else if (arr[mid / wid][mid % wid] > target) right = mid - 1;
			 else left = mid + 1;
		 }
		 return null;
	 }
	 
	 /**
	  * 找到数组中最近的数
	  * 
	  * binary search实际上是抛弃一半再去比
	  * while(left + 1 < right)
	  */
	 public static int cloest(int[] arr, int target) {
		 int len = arr.length;
		 int left = 0;
		 int right = arr.length - 1;
		 int mid;
		 
		 while(left + 1 < right) {
			 mid = (left + right) / 2;
			 if(target < arr[mid]) {
				 right = mid;
			 } else {
				 left = mid;
			 }
		 }
		 if(Math.abs(arr[left] - target) < Math.abs(arr[right] - target)) {
			 return arr[left];
		 } else {
			 return arr[right];
		 }
	 }
	 
	 
	
	
	public static void main(String[] args) {
		int[][] arr2D = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[] arr = new int[]{1,3,5,8,9};
		System.out.println(cloest(arr, 7));
//		
//		System.out.println(classicSearch(arr, 2));
//		System.out.println(Arrays.toString(matrixSearch(arr2D, 8)));
	}

}
