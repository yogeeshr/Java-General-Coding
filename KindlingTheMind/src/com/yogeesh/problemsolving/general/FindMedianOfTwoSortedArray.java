package com.yogeesh.problemsolving.general;


/**
 * @author yogeesh.srkvs@gmail.com
 */
public class FindMedianOfTwoSortedArray {

    public static void swap(StringBuffer str, int i, int j) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }

    public static void permute(StringBuffer str, int leastIndex) {
        //recursion terminating condition
        if (leastIndex == str.length() - 1) {
            System.out.println(str);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            swap(str, leastIndex, i);
            FindPermutationsOfString.permute(str, leastIndex + 1);
            swap(str, leastIndex, i); //setting string back to how it was
        }
    }

    public static void main(String[] args) {
        // yet to complete
        int[] a = {1, 2, 3, 4, 5, 6}, b = {4, 5, 6, 7};
    }

}
