package com.practice.leetcode;

/*
 * Valley peak approach.
 */
public class BuyAndSell {

    public static int maxProfit(int[] arr) {
        int n = arr.length;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }

    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int[] prices = { 5,3,1 };
        System.out.println("Max Profit:" + maxProfit(prices));
    }
}

