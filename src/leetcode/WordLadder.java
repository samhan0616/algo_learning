package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class WordLadder {
    String start;
    String end;
    HashSet<String> visited = new HashSet<>();
    ArrayList<List<String>> container = new ArrayList<>();
    int res = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //1. todo verify
        if (!wordList.contains(endWord)) return 0;
        start = beginWord;
        end = endWord;
        List<String> set = new ArrayList<String>();
        set.add(start);
        backtracking(set, wordList, start);
        return res == Integer.MAX_VALUE ? 0 : res;

    }

    void backtracking(List<String> set, List<String> wordList, String curr) {
        if (curr.equals(end)) {
            container.add(new ArrayList<>(set));
            res = Math.min(res, set.size());
            set.remove(set.size() - 1);
            visited.remove(curr);
            return;
        } else {
            visited.add(curr);
        }
        List<String> neibors = finddiff1(wordList, curr);
        for (String str : neibors) {
            if (set.contains(str)) continue;
            else {
                set.add(str);
                backtracking(set, wordList, str);
            }
        }

        visited.remove(set.get(set.size() - 1));
        set.remove(set.size() - 1);
    }

    List<String> finddiff1(List<String> wordList, String curr) {
        List<String> ret = new ArrayList<String>();
        for(String str : wordList) {
            if (str.equals(curr) || visited.contains(str)) continue;
            else {
                int diff = 0;
                for (int i = 0; i < curr.length(); i++) {
                    if (curr.charAt(i) != str.charAt(i)) diff++;
                }
                if (diff == 1 ) {
                    ret.add(str);
                }
            }
        }
        return ret;
    }




    public static void main(String[] args) {
        String[] arr = new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        WordLadder wordLadder =  new WordLadder();
        int res = wordLadder.ladderLength("qa", "sq", Arrays.asList(arr));
        System.out.println(res);
        System.out.println(wordLadder.container);

    }



}
