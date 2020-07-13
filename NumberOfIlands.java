package test;

public class NumberOfIlands {

	public static int numberOfIlands(int[][] grids) {
		int rows = grids.length;
		int columns = grids[0].length;
		int count = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (grids[i][j] == 1) {
					count++;
					dfs(grids, i, j);
				}
			}
		}
		return count;
	}

	private static void dfs(int[][] grids, int i, int j) {
		if (i < 0 || i >= grids.length || j < 0 || j >= grids[0].length || grids[i][j] == 0) {
			return;
		}
		grids[i][j] = 0;
		dfs(grids, i + 1, j); // up
		dfs(grids, i - 1, j); // down
		dfs(grids, i, j - 1); // left
		dfs(grids, i, j + 1); // right

	}

	public static void main(String args[]) {
		int[][] grids = { { 1, 1, 0 }, { 1, 0, 0 }, { 0, 0, 1 }, { 1, 1, 1 } }; // 2 rows and 3 columns
		System.out.println("No of islands: " + numberOfIlands(grids));
	}

	/*
	 * 1, 1, 0 
	 * 1, 0, 0 
	 * 0, 0, 1
	 * 1, 1, 1
	 * o/p: 1 island
	 * 
	 */

}
