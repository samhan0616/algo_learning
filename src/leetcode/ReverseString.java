package leetcode;

public class ReverseString {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        char[] charArr = s.toCharArray();
        reverse(charArr, 0 , charArr.length - 1);
        int i =0, j=0;
        boolean space = false;

        while (j < charArr.length) {
            if (charArr[j] == ' ' && !space)  {
                reverse(charArr, i, j - 1);
                i = j + 1;
                space = !space;
            }  else if (charArr[j] != ' '){
                if (space) {
                    i = j;
                    space = !space;
                }
            }

            j++;

        }
        reverse(charArr, i, j- 1);
        return new String(charArr);
    }

    public void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start ++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
        new ReverseString().reverseWords("  Life  doesn't  always    give     us  the       joys we want.");
    }
}