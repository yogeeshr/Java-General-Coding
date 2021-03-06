package com.yogeesh.problemsolving.sorting;

import org.json.JSONArray;

/**
 * @author yogeesh.srkvs@gmail.com
 */
public class QuickSort {

    /**
     * @param a
     * @param least
     * @param highest Sort function
     */
    private static void sort(int[] a, int least, int highest) {
        if (least > highest) {
            return;
        }

        int partition = QuickSort.getPartition(a, least, highest);
        QuickSort.sort(a, least, partition - 1);
        QuickSort.sort(a, partition + 1, highest);
    }

    /**
     * @param a
     * @param least
     * @param highest
     * @return partition index
     */
    private static int getPartition(int[] a, int least, int highest) {

        //taking first element as pivot
        int pivot = least, i = least + 1, j = highest;

        while (true) {
            //go on till you get an element greater than pivot
            while (i <= highest && a[i] <= a[pivot]) {
                i++;
            }

            //go on till you get an element lesser than pivot
            while (j >= least && a[j] > a[pivot]) {
                j--;
            }

            if (i < j) {
                QuickSort.swap(a, i, j);
            } else {
                QuickSort.swap(a, least, j);
                return j;
            }
        }
    }

    /**
     * @param a
     * @param i
     * @param j Utility to swap elements in the array
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * @param a Utility to print array elements
     */
    private static void printElements(int[] a) {
        for (int index = 0; index < a.length; index++) {
            System.out.print(a[index] + " ");
        }
    }

    public static void main(String args[]) {
        try {

            String data = "[{\"userName\": \"sandeep\",\"age\":30},{\"userName\": \"vivan\",\"age\":5}]  ";
            JSONArray jsonArr = new JSONArray(data);

            jsonArr.length();

            System.out.println(jsonArr.length());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
