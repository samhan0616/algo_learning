package leetcode;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        String res = null;
        int i = -1, j = 0, tracker = 0;
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                int freq = map.get(c) - 1;
                if (freq >= 0) {
                    tracker ++;
                }
                map.put(c, freq);
            }
            while (tracker == t.length()) {
                char key = s.charAt(++i);
                if (map.containsKey(key)) {
                    if (map.get(key) + 1 > 0) {
                        map.put(key, map.get(key) + 1);
                        if (res == null || res.length() > j - i + 1) {
                            res = s.substring(i, j +1);
                        }
                        tracker --;
                    } else {
                        map.put(key, map.get(key) + 1);
                    }
                }


            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        //System.out.println(m.minWindow("aaaaaaaaaaaabbbbbcdd","abcdd"));
        System.out.println(m.minWindow("ADOBECODEBANC","ABC"));
    }
}
