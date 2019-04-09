package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaxiumSubtree {


    public List<String> lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        List<String> res = new ArrayList<>();
        int left = 0, right = 0, dup = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
                dup++;
            } else {
                map.put(s.charAt(right), 1);
            }

            if (right - left + 1== k) {
                if (1 == dup) {
                    res.add(s.substring(left, right + 1));
                }
                int freq = map.get(s.charAt(left));
                if (freq > 1) {
                    map.put(s.charAt(left), freq - 1);
                    dup--;
                } else {
                    map.remove(s.charAt(left));
                }
                left ++;
            }
            right ++;
        }

        return res;
    }

    public static void main(String[] args) {
        MaxiumSubtree ob = new MaxiumSubtree();
        String ch = "abcbaa";
        int k = 3;
        System.out.println("Total substrings with exactly " +
                k + " distinct characters : "
                + ob.lengthOfLongestSubstringKDistinct(ch, k));
    }
}


class Node
{
    int key;
    Node left, right;
}
