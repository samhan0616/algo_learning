package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author create by Xiao Han 10/28/18
 * @version 1.0
 * @since jdk 1.8
 */
public class ThreeSum {
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
    new ThreeSum().threeSum(new int []{-1,0,1,2,-1,-4});
  }
}
