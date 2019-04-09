package classic.design;

import java.util.*;

class AutocompleteSystem {

    Node node;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        build(sentences, times);
        this.prefix = "";
    }


    public List<String> input(char c) {
        if (c == '#') {
            prefix = "";
            build(prefix, 1);
            return new ArrayList<>();
        }
        prefix += c;
        return search();

    }

    List<String> search() {
        Node cur = node;
        for (char c : prefix.toCharArray()) {
            if ((cur = cur.get(c)) == null) return new ArrayList<>();
        }
        PriorityQueue<Map.Entry<String, Integer>> pq
                = new PriorityQueue<>((e1, e2) -> e1.getValue() == e2.getValue() ?
                e1.getKey().compareTo(e2.getKey()) : e1.getValue() - e2.getValue());
        for (Map.Entry<String, Integer> entry : cur.count.entrySet()) {
            pq.add(entry);
        }

        List<String> res = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 3) {
            res.add(pq.remove().getKey());
            count++;
        }
        return res;
    }


    void build(String[] s, int[] t) {
        for (int i = 0; i < s.length; i++) {
            String str = s[i];
            build(str,t[i]);
        }
    }

    void build(String s, int time) {
        Node cur = node;
        for (char c : s.toCharArray()) {
            if (cur.get(c) == null) cur.put(c);
            cur = cur.get(c);
            cur.count.put(s, cur.count.getOrDefault(cur, 0) + time);
        }
        cur.isWord = true;
    }
}

class Node {
    char val;
    Node[] next;
    HashMap<String, Integer> count;
    boolean isWord;
    public Node(char val) {
        this.val = val;
        next = new Node[26];
        this.count = new HashMap<>();
    }

    public Node get(char c) {
        return next[c - 'a'];
    }

    public Node put(char c) {
        Node node = new Node(c);
        next[c - 'a'] = node;
        return node;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */