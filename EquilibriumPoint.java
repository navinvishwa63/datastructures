package com.practice.leetcode;

public class EquilibriumPoint {

    public static int findEquilibriumPoint(int[] arr) {
        int n = arr.length;
        int leftsum = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        for (int i = 0; i < n; i++) {
            sum -= arr[i];
            if (leftsum == sum) {
                return i;
            }
            leftsum += arr[i];
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] arr = { 1, 2, 6, 4, 0, -1 };
        System.out.println(findEquilibriumPoint(arr));
    }
}
