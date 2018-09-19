package struct;
import java.util.LinkedList;
public class Tree {
	TreeNode root;
	
	/**
	 * 
	 * @param val
	 * @param left
	 * @param right
	 */
	void addNode(int val, Integer left, Integer right){
		if (root == null) {
			root = new TreeNode(val);
			return;
		}
		TreeNode curr = new TreeNode(val);
		if(left == null && right == null) throw new RuntimeException("Parent cannot be null");
		int target = left == null ? right : left;
		TreeNode parent = find(this.root, target);
		if (left == null) {
			parent.right = curr;
		} else {
			parent.left = curr;
		}
	}
	/**
	 * 
	 * @param node
	 * @param val
	 * @return
	 */
	TreeNode find(TreeNode node, int val){
		TreeNode ptr;
		if(node == null) {
			return null;
		} else {
			if(node.data == val) {
				return node;
			} else {
				if((ptr = find(node.left, val))!= null) return ptr;
				else if((ptr = find(node.right, val))!= null) return ptr;
				else return null;
			}
		}
	}
	/**
	 * 深度
	 * @param node
	 * @return
	 */
	int depth(TreeNode node){
		int left,right;
		if(node == null) return 0;
		else {
			left = depth(node.left);
			right = depth(node.right);
			return Math.max(left, right) + 1;
		}
	}
	/**
	 * 宽度 递归
	 * @param args
	 */
	int witdth1(){
		int[] count = new int[depth(this.root)];
		widthRec(this.root, count, 0);
		return max(count);
	}
	void widthRec(TreeNode node,int count[], int level) {
		if(node != null) {
			count[level] ++;
			widthRec(node.left, count, level + 1);
			widthRec(node.right, count, level + 1);
		}
	}
	int max(int count[]){
		int result = count[0];
		for(int i = 1; i < count.length; i++) {
			result = Math.max(result, count[i]); 
		}
		return result;
	}
	
	/**
	 * 宽度 非递归
	 * @param args
	 */
	int width2() {
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		nodes.offer(this.root);
		int len;
		int max = 1;
		while(true) {
			len = nodes.size();
			if(len == 0) break;
			while(len > 0) {
				TreeNode curr = nodes.poll();
				len--;
				if(curr.left != null) nodes.offer(curr.left);
				if(curr.right != null) nodes.offer(curr.right);
			}
			max = Math.max(max, nodes.size());
		}
		return max;
	}
	/**
	 * 先序遍历
	 * @param args
	 */
	void LDR(TreeNode node) {
		if(node != null) {
			System.out.print(node.data+ " ");
			LDR(node.left);
			LDR(node.right);
		}
	}
	/**
	 * 中序遍历
	 * @param args
	 */
	void DLR(TreeNode node) {
		if(node != null) {
			DLR(node.left);
			System.out.print(node.data+ " ");
			DLR(node.right);
		}
	}
	/**
	 * 后序遍历
	 * @param args
	 */
	void LRD(TreeNode node) {
		if(node != null) {
			LRD(node.left);
			LRD(node.right);
			System.out.print(node.data+ " ");
		}
	}
	/**
	 * 层次遍历
	 * @param args
	 */
	void level(){
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		nodes.offer(this.root);
		int len;
		while(true) {
			len = nodes.size();
			if(len == 0) break;
			while(len > 0) {
				TreeNode curr = nodes.poll();
				System.out.print(curr.data + " ");
				len--;
				if(curr.left != null) nodes.offer(curr.left);
				if(curr.right != null) nodes.offer(curr.right);
			}
		}
	}
	/***************搜索树***************/
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.addNode(1, null, null);
		tree.addNode(2, 1, null);
		tree.addNode(3, null, 1);
		tree.addNode(4, 2, null);
		tree.addNode(5, null, 2);
		tree.addNode(6, null, 3);
		tree.addNode(7, 5, null);
		tree.addNode(8, null, 5);
		System.out.println(tree.width2());
		tree.LDR(tree.root);
		System.out.println();
		tree.DLR(tree.root);
		System.out.println();
		tree.LRD(tree.root);
		System.out.println();
		tree.level();
	}
}
