package struct;

import java.util.Arrays;
import java.util.HashMap;

public class RecursionPractice {
	public static void main(String[] args) {
		int nums[] = new int[]{2,7,11,15};
		System.out.println(Arrays.toString(twoSum(nums, 9)));
	}
	
	/**
	 * 1 +..+	 100
	 */
	int sum = 0;
	static int addSum(int n, int sum) {
		if (n == 0) return sum;
		sum += n--;
		return addSum(n, sum);
	}
	
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) == null) map.put(nums[i], i);
            else return new int[]{map.get(target - nums[i]), i};         
        }
        return null;
    }
}
