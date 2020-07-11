package com.practice.leetcode;

import java.util.Arrays;

public class MoveZeros {

    /**
     * Using extra space.
     */
    public static int[] moveZerosEnd(int[] arr) {
        int[] out = new int[arr.length];
        int counter = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                out[j++] = arr[i];
            } else {
                counter++;
            }
        }
        while (counter > 0) {
            out[j++] = 0;
            counter--;
        }
        return out;
    }

    // No extra space.
    public static int[] moveZerosEndInplace(int[] arr) {
        int n = arr.length;
        int i = 0, j = 0;
        if (n == 0 || n == 1) {
            return arr;
        }
        while (j < n) {
            if (arr[j] == 0) {
                j++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        return arr;
    }


    public static void main(String args[]) {
        int[] arr = { 0, 1, 0, 3, 0, 13, 12, 56 };
        int[] arr1 = { 0, 1, 0, 1, 0, 1, 1, 1 };
        System.out.println(Arrays.toString(moveZerosEnd(arr)));
        System.out.println(Arrays.toString(moveZerosEndInplace(arr1)));
    }
}
