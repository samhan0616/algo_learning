package classic.string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        while (true) {
            for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); --i)
                back += S.charAt(i) == '#' ? 1 : -1;
            for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); --j)
                back += T.charAt(j) == '#' ? 1 : -1;
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--; j--;
            } else
                return i == -1 && j == -1;
        }
    }

    public String addStrings(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        char[] res = new char[Math.max(n1.length, n2.length) + 1];
        helper(n1, n1.length -1, n2, n2.length -1, 0, res, res.length - 1);
        String ress = new String(res);
        return ress.charAt(0) == ' ' ?
                ress.substring(1) :
                ress;
    }

    void helper(char[] n1, int i, char[] n2, int j, int carry, char[] res, int r) {
        if (i < 0 && j < 0) return;
        int sum = (i >= 0 ? (n1[i] - '0') : 0) + (j >= 0 ? (n2[j] - '0') : 0) + carry;
        res[r] = (char) (sum % 10 + '0');
        helper(n1,--i,n2,--j,sum/10,res, --r);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] pr = new int[26];
        for (char c : p.toCharArray()) {
            pr[c-'a']++;
        }

        int[] sr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sr[s.charAt(i) - 'a']++;
        }
        LinkedList<Integer> res = new LinkedList<>();
        if (Arrays.equals(sr,pr)) {
            res.add(0);
        }
        int pl = p.length();
        for (int i = 1; i < s.length() -pl; i++) {
            sr[s.charAt(i - 1) - 'a'] --;
            sr[s.charAt(i + pl - 1) - 'a'] ++;
            if (Arrays.equals(sr,pr)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) return true;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (s.charAt(i) == ' ' || !Character.isLetter(s.charAt(i))) i++;
            while (s.charAt(j) == ' ' || !Character.isLetter(s.charAt(j))) j--;
            if ( i< j && Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;j--;
        }
        return true;
    }


    public static void main(String[] args) {
        //System.out.println(new BackspaceStringCompare().backspaceCompare("a##c", "#a#c"));

//        System.out.println(new BackspaceStringCompare().customSortString("cba","abcd"));
    }
}
