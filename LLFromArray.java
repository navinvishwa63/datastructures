package test.tree;

/**
 * Convert given array to Linked list.
 * 
 * @author nvishwakarma
 *
 */
public class LLFromArray {

	static Node root;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	static void display(Node root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.next;
		}
	}

	static Node insertNode(Node root, int data) {
		Node temp = new Node(data);
		temp.next = root;
		root = temp;
		return root;
	}

	static Node buildLinkedListFromArray(int arr[]) {
		int n = arr.length;
		root = null;
		for (int i = n - 1; i >= 0; i--) {
			root = insertNode(root, arr[i]);
		}
		return root;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		Node root = buildLinkedListFromArray(arr);
		display(root);
	}
}
