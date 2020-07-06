package test.tree;

public class JumpProblem {

	public static boolean jump(int[] nums) {

		int n = nums.length;
		int reachable = 0;
		for (int i = 0; i < n; i++) {
			if (reachable < i)
				return false;
			reachable = Math.max(reachable, i + nums[i]);
		}
		return true;
	}

	public static void main(String args[]) {
		int[] nums = { 1, 1, 2, 5, 2, 1, 0, 0, 1, 3 };
		int[] nums2 = { 1, 1, 2, 3, 2, 1, 0, 0, 1, 3 };
		System.out.println(jump(nums));
		System.out.println(jump(nums2));
	}
}
