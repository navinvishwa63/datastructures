package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintRightMostElementsTree {
	Node root;

	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	public static List<Integer> printCorner(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		List<Integer> result = new ArrayList<>();

		// pushing root node and start node
		q.add(root);
		// Do level order traversal of Binary Tree
		while (!q.isEmpty()) {
			// n is the no of nodes in current Level
			int n = q.size();
			for (int i = 0; i < n; i++) {
				// dequeue the front node from the queue
				Node temp = q.peek();
				q.poll();
				// If rightmost corner value then print it
				if (i == n - 1) { // n==0 for left most elements
					result.add(temp.data);
				}
				// push the left and right children of the temp node
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		PrintRightMostElementsTree tree = new PrintRightMostElementsTree();
		tree.root = new Node(15);
		tree.root.left = new Node(10);
		tree.root.right = new Node(20);
		tree.root.left.left = new Node(8);
		tree.root.left.right = new Node(12);
		tree.root.right.left = new Node(16);
		tree.root.right.right = new Node(25);
		tree.root.right.right.left = new Node(29);
		tree.root.right.right.left.right = new Node(100);
		tree.root.right.right.left.left = new Node(101);

		System.out.println(PrintRightMostElementsTree.printCorner(tree.root));
	}
}
