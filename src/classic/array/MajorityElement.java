package classic.array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public List<Integer> majorityElement(int... nums) {
        int n1 = 0, n2 = 0, c1 = 0, c2 = 0;

        for (int n : nums) {
            if (n == n1) c1++;
            else if (n == n2) c2++;
            else if (c1 == 0) n1 = n;
            else if (c2 == 0) n2 = n;
            else {
                c1 --; c2--;
            }
        }




        c1 = 0; c2 = 0;
        for (int n : nums) {
            if (n == n1) c1++;
            else if (n == n2) c2++;
        }


        List<Integer> res = new ArrayList<>();
        if (c1 > nums.length / 3) res.add(n1);
        if (c2 > nums.length / 3) res.add(n2);

        return res;
    }

    public static void main(String[] args) {
        new MajorityElement().majorityElement(1,2);
    }
}
