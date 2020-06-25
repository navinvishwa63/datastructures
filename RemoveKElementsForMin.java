package test.tree;

import java.util.Arrays;
import java.util.Stack;

/**
 * Remove K elements from a given string number so that the string number should
 * be minimum.
 * 
 * @author nvishwakarma
 *
 */
public class RemoveKElementsForMin {

	public static String removeElements(String num, int k) {
		String result = "";

		Stack<Character> stack = new Stack<Character>();
		char arr[] = num.toCharArray();
		for (char c : arr) {
			while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
				stack.pop();
				k--;
			}
			if (!stack.isEmpty() || c != '0') {
				stack.push(c);
			}
		}

		while (!stack.empty() && k-- >0) {
			stack.pop();
		}
		if (stack.empty())
			return "0";

		while (!stack.empty()) {
			result = stack.pop().toString() + result ;
		}
		return result;
	}
	
	public static void main(String args[]) {
		String result = removeElements("1230987", 3);
		System.out.println(result);
	}
}
