package classic.array;

import java.util.LinkedList;
import java.util.Queue;

public class IntervalStatic {

    public long intervalStatistics(int[] arr, int k) {
        Queue<Integer> q = new LinkedList<>();
        int zeros = 0, ones = 0, rem = 0;
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeros ++;
                q.offer(arr[i]);
            } else if (arr[i] == 1 && zeros > 0){
                ones ++;
                q.offer(arr[i]);
            }
            if (ones > k) {
                while (i < arr.length - 1 && arr[i + 1] == 1) {
                    q.offer(arr[++i]);
                    ones ++;
                }
                res += (1 + zeros)  * zeros / 2 - ((1 + rem)  * rem / 2);
              while (ones > k) {
                  int temp = q.poll();
                  if (temp == 0) zeros --;
                  if (temp == 1) ones --;
              }
              if (zeros == 0) {
                  rem = 0;
                  q.clear();
                  ones = 0;
              } else {
                  rem = zeros;
              }
            }
        }
        res += (1 + zeros)  * zeros / 2 - ((1 + rem)  * rem / 2);
        return  res;
    }


    public static void main(String[] args) {
        int[] input = new int[]{0,0,1,1,0,1,0,0,1};

        System.out.println(new IntervalStatic().intervalStatistics(input, 2));
    }
}
