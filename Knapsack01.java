/**
* Knapsack 0/1 is bounded. if choice given, either take it or don't.
*/

public class Knapsack01 {

    private static int dp[][] = new int[102][1002]; // the n and m (size of weight array and W capacitu of sack must be given in question.)

    public static int knapsackRec(int wt[], int val[], int w, int n) {

        // Base condition
        if (n == 0 || w == 0) {
            return 0;
        }
        // ==========Memoization=======
        if (dp[n][w] != -1)
            return dp[n][w];
        // =================

        if (wt[n - 1] <= w) {
            return dp[n][w] = Math.max(val[n - 1] + knapsackRec(wt, val, w - wt[n - 1], n - 1),
                                       knapsackRec(wt, val, w, n - 1));
        } else {
            return dp[n][w] = knapsackRec(wt, val, w, n - 1);
        }
    }

}
