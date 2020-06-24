package test.tree;

import java.util.HashMap;

/**
 * 
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 */
public class MinimumWindowSubstring {

	public static String minWindow(String s, String t) {
		if (s == null || s.length() < t.length()) {
			return "";
		}
		String result = "";
		int letterCount[] = new int[128];
		int left = 0;
		int count = 0;
		int minLen = Integer.MAX_VALUE;

		for (char c : t.toCharArray()) {
			++letterCount[c];
		}
		for (int right = 0; right < s.length(); ++right) {
			if (--letterCount[s.charAt(right)] >= 0)
				++count;
			while (count == t.length()) {
				if (minLen > right - left + 1) {
					minLen = right - left + 1;
					result = s.substring(left, right + 1);
				}
				if (++letterCount[s.charAt(left)] > 0)
					--count;
				++left;
			}
		}
		return result;
	}

	public static void main(String args[]) {
		String result = minWindow("ADOBECODEBANC", "ABC");
		System.out.println(result);
	}
}
