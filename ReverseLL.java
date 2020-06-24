package test.tree;

public class ReverseLL {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}
	}

	static Node revertLinkedList(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String args[]) {

		Node root = new Node(1);
		root.next = new Node(5);
		root.next.next = new Node(10);
		root.next.next.next = new Node(15);
		System.out.print("Original List : ");
		printList(root);
		System.out.print("Reversed List : ");
		printList(revertLinkedList(root));

	}
}
