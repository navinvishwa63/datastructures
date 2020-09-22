public class CoinChangeMinWays {
  
      public static int coinChangeMin(int[] coins, int amount, int n) {
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = 0;
        for (int j = 0; j < amount + 1; j++)
            dp[0][j] = Integer.MAX_VALUE - 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] <= j)
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        if (dp[n][amount] == Integer.MAX_VALUE - 1)
            return -1;
        else
            return dp[n][amount];
    }
    
    public static void main(String atgs[]) {
        int arr[] = { 1, 2, 3 };
        int arr1[] = { 3, 1, 2, 4, 5 };
        int sum = 4;
        System.out.println(coinChangeMin(arr, 5, 3));
    }

}
