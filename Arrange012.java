package com.practice.leetcode;

import java.util.Arrays;

public class Arrange012 {

    public static void main(String args[]) {
        int[] arr = { 0, 2, 1, 0, 2, 0, 1 };
        System.out.println(Arrays.toString(rearrage012(arr)));
    }

    /**
     * Using 3 pointers left, mid and right. Mid will trace whole array.
     */
    public static int[] rearrage012(int[] arr) {
        int n = arr.length;
        int left = 0, mid = 0, right = n - 1;
        while (mid <= right) {
            if (arr[mid] == 0) {
                swap(arr, left, mid);
                left++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, right);
                right--;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

// {0,2,1,0,2,0,1}
