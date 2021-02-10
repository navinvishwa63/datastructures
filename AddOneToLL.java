package test.tree;

public class AddOneToList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}

	}

	// return carry after adding 1 from end to start.
	static int addWithCarry(Node node) {
		if (node == null) {
			return 1;
		}

		int res = node.data + addWithCarry(node.next);
		node.data = res % 10;
		res /= 10;
		return res;
	}

	static Node addOneToList(Node node) {
		int carry = addWithCarry(node);
		if (carry > 0) {
			Node temp = new Node(carry);
			temp.next = node;
			return temp;

		}
		return node;
	}

	static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + "");
			node = node.next;
		}

	}

	public static void main(String args[]) {
		Node head = new Node(1);
		head.next = new Node(9);
		head.next.next = new Node(9);
		head.next.next.next = new Node(9);
		System.out.print("Before: ");
		printList(head);
		System.out.print("\nAfter: ");
		printList(addOneToList(head)); // 2000

	}

}
