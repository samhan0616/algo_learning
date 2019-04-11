package leetcode.leetcode_51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 *
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 *              Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 *
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class Lc68_Text_justification {
    /**
     * just a simulation question
     * no specific algo needed
     * but have to take care of every case
     * like: hanlde the last line
     * care about the extra spaces
     * @param words
     * @param maxWidth
     * @return
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int len = 0, lastI = 0;

        for (int i = 0; i <= words.length; i++) {
            if (i == words.length || i - lastI + len + words[i].length() > maxWidth) {
                int interval = i - lastI - 1, spaces = maxWidth - len;
                StringBuilder sb = new StringBuilder();
                if (interval == 0 || i == words.length) {
                    for (int j = lastI; j < i; j ++) {
                        sb.append(words[j]);
                        if (j != i - 1) sb.append(" ");
                    }
                    appendSpace(sb, maxWidth - sb.length());
                } else {
                    int extra = spaces % interval, average = spaces / interval;
                    for (int j = lastI; j < i; j ++) {
                        sb.append(words[j]);
                        if (j != i - 1) {
                            appendSpace(sb, average + (extra-- > 0 ? 1 : 0));
                        }
                    }
                }
                res.add(sb.toString());
                lastI = i;
                len = 0;
            }

            if (i < words.length) {
                len += words[i].length();
            }
        }
        return res;
    }


    private void appendSpace(StringBuilder sb, int count) {
        for (int i = 0; i < count; i++)
            sb.append(' ');
    }

}
