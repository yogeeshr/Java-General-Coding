package com.yogeesh.problemsolving.sorting;

/**
 * @author yogeesh.srkvs@gmail.com
 *
 * Warning : Code is not complete
 *
 */
public class MergeSort {

    static int a[] = {8, 1, 20, -1 , -3, 50, 100, 10};
    static int[] tempArr = new int[a.length];

    public static void main (String args[]) {

        System.out.println("Array elements before sorting : ");
        MergeSort.printElements(a);
        MergeSort.sort(a, 0, a.length-1);
        System.out.println("\nArray elements after sorting : ");
        MergeSort.printElements(tempArr);
    }

    private static void sort(int[] a, int i, int j) {
        if (i>j) {
            int m=(i+j)/2;
            MergeSort.sort(a, i, m);
            MergeSort.sort(a, m+1, j);
            tempArr = MergeSort.merge(tempArr, i, m, j);
        }
    }

    private static int[] merge(int[] arr, int l, int m, int e) {
        int a, b, c, d=0;
        //length of left array
        a = m-l+1;
        //length of right array
        b = m-e;

        int[] lArr = new int[a], rArr = new int[b];

        for (int index=0; index<a; index++){
            lArr[index] = arr[l+index];
        }

        for (int index=0; index<b; index++){
            rArr[index] = arr[m+1+index];
        }

        int i=0, j=0;

        while (i<lArr.length && j<rArr.length) {
            if (lArr[i] < rArr[j]) {
                arr[d++] = lArr[i++];
            } else {
                arr[d++] = rArr[j++];
            }
        }

        while (i<lArr.length) {
            arr[d++] = lArr[i++];
        }

        while (j<lArr.length) {
            arr[d++] = rArr[j++];
        }

        return arr;
    }

    private static void printElements(int[] a) {
        for (int i=0; i<a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}