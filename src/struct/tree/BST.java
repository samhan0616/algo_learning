package struct.tree;

/**
 * @author create by Xiao Han 10/8/18
 * @version 1.0
 * @since jdk 1.8
 */
public class BST {
  TreeNode root;

  public void inorder(TreeNode node) {
    if (node != null) {
      inorder(node.left);
      System.out.print(node.data + " ");
      inorder(node.right);
    }
  }

  public void insert(int key) {
      TreeNode x = root;
      TreeNode y = null;
      while (x != null) {
        y = x;
        if (x.data > key) {
          x = x.left;
        } else {
          x = x.right;
        }
      }
      if (y == null) {
        root = new TreeNode(key);
      } else {
        if (y.data > key) {
          y.left = new TreeNode(key);
          y.left.parent = y;
        } else {
          y.right = new TreeNode(key);
          y.right.parent = y;
        }
      }
  }


  TreeNode search(int k) {
    if (root == null) return null;
    TreeNode x = root;
    while (x != null) {
      if (x.data == k) {
        return x;
      } else if (x.data < k) {
        x = x.right;
      } else {
        x = x.left;
      }
    }
    return x;
  }

  int maxium(int x) {
    TreeNode k = search(x);
    if (k == null) return -1;
    while (k.right != null) {
      k = k.right;
    }
    return k.data;
  }

  TreeNode minium(int x) {
    TreeNode k = search(x);
    if (k == null) return null;
    while (k.left != null) {
      k = k.left;
    }
    return k;
  }

  int successor(int x) {
    TreeNode k = search(x);
    if (k == null) return -1;
    if (k.right != null) {
      return k.right.data;
    } else {
      TreeNode l = k.parent;
      while (l != null && k == l.right) {
        k = l;
        l = l.parent;
      }
      if (l == null) {
        return -1;
      } else {
        return l.data;
      }
    }
  }

  int predessor(int x) {
    TreeNode k = search(x);
    if (k == null) return -1;
    if (k.left != null) {
      return k.left.data;
    } else {
      TreeNode l = k.parent;
      while (l != null && k == l.left) {
        k = l;
        l = l.parent;
      }
      if (l == null) {
        return -1;
      } else {
        return l.data;
      }
    }
  }

  void transplant(TreeNode n, TreeNode m) {
    if (n.parent == null) root = m;
    else if (n == n.parent.left) {
      n.parent.left = m;
    } else {
      n.parent.right = m;
    }
    if (m != null) {
      m.parent = n.parent;
    }
  }

  void delete (int k) {
    TreeNode n = search(k);
//    System.out.println(n.left.data);
    if (n.left == null) {
      transplant(n, n.right);
    } else if (n.right == null) {
      transplant(n, n.left);
    } else  {
      TreeNode m = minium(n.right.data);
      if (m.parent != n) {
        transplant(m, m.right);
        m.right = n.right;
        m.right.parent = m;
      }
      transplant(n,m);
      m.left = n.left;
      m.left.parent = m;
    }
  }


  public static void main(String[] args) {
    BST bst = new BST();
    bst.insert(4);
    bst.insert(10);
    bst.insert(3);
    bst.insert(5);
    bst.insert(15);
    bst.insert(11);
    bst.insert(12);
    bst.insert(8);
//    bst.inorder(bst.root);
//    System.out.println();
//    System.out.println(bst.search(6).data);
//    System.out.println(bst.minium(4));
//    System.out.println(bst.maxium(6));
//    System.out.println(bst.predessor(5));
    bst.delete(10);
    bst.inorder(bst.root);
  }
}
