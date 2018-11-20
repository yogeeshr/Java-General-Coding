package com.yogeesh.problemsolving.dynamic_programming;

/**
 * Created by yogeesh.srkvs@gmail.com on 8/4/17.
 */
public class MoveAllZerosToEndMaintainOrder {

    /**
     * Mthos to swap values in indicies
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        return;
    }

    public static void main(String[] args) {
        int arr[] = {0, -2000, 0, 0, 0, -1, 2000, -4000, 0, 10000, 15000, 1000, 0}, start = -1;

        for (int i = 0; i < arr.length; i++) {

            if (start == -1 && arr[i] == 0) {
                start = i;
                continue;
            }

            if (arr[i] != 0 && start != -1) {
                swap(arr, i, start);
                start = start + 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
