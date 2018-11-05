package struct.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Tree {
  TreeNode root;

  /**
   * @param val
   * @param left
   * @param right
   */
  void addNode(int val, Integer left, Integer right) {
    if (root == null) {
      root = new TreeNode(val);
      return;
    }
    TreeNode curr = new TreeNode(val);
    if (left == null && right == null) throw new RuntimeException("Parent cannot be null");
    int target = left == null ? right : left;
    TreeNode parent = find(this.root, target);
    if (left == null) {
      parent.right = curr;
    } else {
      parent.left = curr;
    }
    curr.parent = parent;
  }

  /**
   * @param node
   * @param val
   * @return
   */
  TreeNode find(TreeNode node, int val) {
    TreeNode ptr;
    if (node == null) {
      return null;
    } else {
      if (node.data == val) {
        return node;
      } else {
        if ((ptr = find(node.left, val)) != null) return ptr;
        else if ((ptr = find(node.right, val)) != null) return ptr;
        else return null;
      }
    }
  }

  /**
   * 深度
   *
   * @param node
   * @return
   */
  int depth(TreeNode node) {
    int left, right;
    if (node == null) return 0;
    else {
      left = depth(node.left);
      right = depth(node.right);
      return Math.max(left, right) + 1;
    }
  }

  /**
   * 宽度 递归
   */
  int witdth1() {
    int[] count = new int[depth(this.root)];
    widthRec(this.root, count, 0);
    return max(count);
  }

  void widthRec(TreeNode node, int count[], int level) {
    if (node != null) {
      count[level]++;
      widthRec(node.left, count, level + 1);
      widthRec(node.right, count, level + 1);
    }
  }

  int max(int count[]) {
    int result = count[0];
    for (int i = 1; i < count.length; i++) {
      result = Math.max(result, count[i]);
    }
    return result;
  }

  /**
   * 宽度 非递归
   */
  int width2() {
    LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
    nodes.offer(this.root);
    int len;
    int max = 1;
    while (true) {
      len = nodes.size();
      if (len == 0) break;
      while (len > 0) {
        TreeNode curr = nodes.poll();
        len--;
        if (curr.left != null) nodes.offer(curr.left);
        if (curr.right != null) nodes.offer(curr.right);
      }
      max = Math.max(max, nodes.size());
    }
    return max;
  }

  /**
   * 先序遍历
   */
  void LDR(TreeNode node) {
    if (node != null) {
      System.out.print(node.data + " ");
      LDR(node.left);
      LDR(node.right);
    }
  }

  /**
   * 中序遍历
   */
  void DLR(TreeNode node) {
    if (node != null) {
      DLR(node.left);
      System.out.print(node.data + " ");
      DLR(node.right);
    }
  }

  /**
   * 后序遍历
   */
  void LRD(TreeNode node) {
    if (node != null) {
      LRD(node.left);
      LRD(node.right);
      System.out.print(node.data + " ");
    }
  }

  /**
   * 层次遍历
   */
  void level() {
    LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
    nodes.offer(this.root);
    int len;
    while (true) {
      len = nodes.size();
      if (len == 0) break;
      while (len > 0) {
        TreeNode curr = nodes.poll();
        System.out.print(curr.data + " ");
        len--;
        if (curr.left != null) nodes.offer(curr.left);
        if (curr.right != null) nodes.offer(curr.right);
      }
    }
  }


  void morrisIteration() {
    TreeNode curr = this.root;
    while (curr != null) {
      if (curr.left == null) {
        System.out.print(curr.data + " ");
        curr = curr.right;
      } else {
        TreeNode temp = curr.left;
        while (temp.right != null && temp.right != curr) {
          temp = temp.right;
        }
        if (temp.right == null) {
          temp.right = curr;
          curr = curr.left;
        } else {
          System.out.print(curr.data + " ");
          temp.right = null;
          curr = curr.right;

        }
      }
    }
  }

  void morris() {
    TreeNode curr = this.root;
    TreeNode temp = null;
    while (curr != null) {
      if (curr.left == null) {
        System.out.print(curr.data);
        curr = curr.right;
      } else {
        temp = curr.left;
        while (temp.right != null && temp.right != curr) {
          temp = temp.right;
        }
        if (temp.right == null) {
          temp.right = curr;
          curr = curr.left;
        } else {
          System.out.print(curr.data);
          temp.right = null;
          curr = curr.right;
        }
      }
    }
  }

  void homeWork1() {
    TreeNode curr = this.root;
    TreeNode temp = null;
    while (curr != null) {
      if (temp != curr.left) {
        while (curr.left != null) {
          curr = curr.left;
        }
      }
      System.out.print(curr.data + " ");
      if (curr.right != null) {
        curr = curr.right;
      } else {
        do {
          temp = curr;
          if (curr.parent == null) return;
          curr = curr.parent;
        } while (temp == curr.right);
      }
    }
  }


  public boolean inorderTraversal(TreeNode root) {
    // write your code here
    ArrayList<Integer> result=new ArrayList<Integer>();
    Stack<TreeNode> stack=new Stack<TreeNode>();
    TreeNode curt=root;
    TreeNode temp = null;
    while(curt!=null||!stack.empty()){
      while(curt!=null){
        stack.add(curt);
        curt=curt.left;
      }
      curt=stack.pop();
      if (temp == null) {
        temp = curt;
      } else {
        if (temp.data > curt.data) {
          return false;
        } else {
          temp = curt;
        }
      }
      curt=curt.right;
    }
    return true;
  }


    /***************搜索树***************/
    public static void main (String[]args){
      Tree tree = new Tree();
      tree.addNode(6, null, null);
      tree.addNode(4, 6, null);
      tree.addNode(2, 4,null);
      tree.addNode(5, null, 4);
      tree.addNode(8, null, 6);
      tree.addNode(7, 8, null);
      tree.addNode(10, null, 8);
      tree.addNode(9, 10, null);
      tree.addNode(11, null, 10);
//		System.out.println(tree.width2());
//		tree.LDR(tree.root);
//		System.out.println();
//		tree.DLR(tree.root);
//		System.out.println();
//		tree.LRD(tree.root);
//		System.out.println();
//		tree.level();
//        tree.DLR(tree.root);
//        System.out.println();
//        tree.morrisIteration();
//      System.out.println(tree.inorderTraversal(tree.root));
      tree.morris();
    }
  }
