package test.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagrams {

	public static List<Integer> findAnagram(String s, String p) {
		int len = s.length();
		int window = p.length();

		List<Integer> result = new LinkedList<>();

		// base condition
		if (len < window)
			return result;

		int[] hash = new int[128];
		int[] phash = new int[128];
		int left = 0, right = 0;
    
    // we can use 'a' as well but use Math.abs(p.charAt(right) - 'A')
		while (right < window) {
			phash[p.charAt(right) - 'A'] += 1;
			hash[s.charAt(right) - 'A'] += 1;
			right++;
		}
		right--; // bring right pointer back to window size.
		while (right < len) {
			if (Arrays.equals(phash, hash)) {
				result.add(left);
			}
			right += 1;
			if (right != len)
				hash[s.charAt(right) - 'A'] += 1;
			hash[s.charAt(left) - 'A'] -= 1;
			left++;
		}

		return result;
	}

	public static void main(String args[]) {
		 List<Integer> indexes_caps = findAnagram("ABCDEBACB", "BAC");
		List<Integer> indexes = findAnagram("abcdebacb", "bac");
		System.out.println(indexes);
		System.out.println(indexes_caps);
	}
}
