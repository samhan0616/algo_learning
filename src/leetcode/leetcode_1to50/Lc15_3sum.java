package leetcode.leetcode_1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Lc15_3sum {

  /**
   * sort and use two pointer to find combination
   * need to take care about the duplicate
   * @param nums
   * @return
   */
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    int index = 0;
    while (index < nums.length) {
      if (nums[index] >= 0) {
        break;
      } else {
        index ++;
      }
    }
    if (index == nums.length - 1 || index == 0) return res;
    int pre = -1;
    for (int i = index; i < nums.length; i++) {
      if (pre == nums[index]) continue;
      int left = i - 1;
      int right = i + 1;
      int num = nums[index];
      while (left > 0 && right <= nums.length -1) {
        if (nums[left] + nums[right] == num * -1) {
          List<Integer> part = new ArrayList<>();
          part.add(nums[left]);
          part.add(nums[right]);
          part.add(nums[index]);
          pre = nums[index];
          res.add(part);
        }
          left --;
          right ++;
        }
      }

    
    return res;
  }

  public static void main(String[] args) {
    new Lc15_3sum().threeSum(new int []{-1,0,1,2,-1,-4});
  }
}
