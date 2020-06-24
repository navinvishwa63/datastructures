package test.tree;

public class BSTCheck {
	Node root;

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	static boolean checkBST(Node node, Node left, Node right) {

		if (node == null) {
			return true;
		}

		if (left != null && node.data <= left.data) {
			return false;
		}
		if (right != null && node.data >= right.data) {
			return false;
		}
		return (checkBST(node.left, left, node) && checkBST(node.right, node, right));
	}

	public static void main(String args[]) {
		BSTCheck tree = new BSTCheck();
		tree.root = new Node(4);
		tree.root.left = new Node(25);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		if (checkBST(tree.root, null, null))
			System.out.println("IS BST");
		else
			System.out.println("Not a BST");
	}
}
