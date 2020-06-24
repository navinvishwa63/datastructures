/**

Input Tree
       A
      / \
     B   C
    / \   \
   D   E   F

Output Tree
       A--->NULL
      / \
     B-->C-->NULL
    / \   \
   D-->E-->F-->NULL
*/

package test.tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int data;
	Node left, right, nextRight;

	Node(int item) {
		data = item;
		left = right = nextRight = null;
	}
}

public class ConnectTreeNodes {
	Node root;

	public void connectNode(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int qlen = q.size();
			Node prev = null, cur;
			while (qlen > 0) {
				cur = q.poll();
				if (prev != null)
					prev.nextRight = cur;
				if (cur.left != null)
					q.offer(cur.left);
				if (cur.right != null)
					q.offer(cur.right);
				prev = cur;
				qlen--;
			}
		}
	}

	public static void main(String args[]) {
		TreeLevelConnection tree = new TreeLevelConnection();
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);

		tree.connectNode(tree.root);

		System.out.println("Following are populated nextRight pointers in " + "the tree"
				+ "(-1 is printed if there is no nextRight)");
		int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.data + " is " + a);
		int b = tree.root.left.nextRight != null ? tree.root.left.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.left.data + " is " + b);
		int c = tree.root.right.nextRight != null ? tree.root.right.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.right.data + " is " + c);
		int d = tree.root.left.left.nextRight != null ? tree.root.left.left.nextRight.data : -1;
		System.out.println("nextRight of " + tree.root.left.left.data + " is " + d);
	}
}
