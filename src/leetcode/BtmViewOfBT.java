package leetcode;

import struct.tree.TreeNode;

import java.util.*;

public class BtmViewOfBT {
    public List<Integer> btmView(TreeNode node) {
        TreeMap<Integer, TreeNode> resMap = new TreeMap<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node, 0);
        resMap.put(0, node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr  = queue.poll();
                int vp = map.get(curr);
                if (curr.left != null) {
                    map.put(curr.left, vp - 1);
                    resMap.put(vp -1, curr.left);
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    map.put(curr.right, vp + 1);
                    resMap.put(vp + 1, curr.right);
                    queue.offer(curr.right);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, TreeNode> entry : resMap.entrySet()) {
            res.add(entry.getValue().data);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(2 & 1);
    }
}
