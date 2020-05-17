package com.yogeesh.problemsolving.dynamic_programming;

/**
 * Created by yogeesh.srkvs@gmail.com on 16 May 2020.
 */
public class LevenshteinDistanceString {

    static int[] arrayToCompute, arrayToLookup;

    public static void main(String[] args) {
        String str1="abcd", str2="lmno";

        System.out.println("Levenshtein Distance of " +  str1 + " and "+ str2 +" is : "
                + getLevenshteinDistance(str1, str2));

        str1="abc";
        str2="abx";
        System.out.println("Levenshtein Distance of " +  str1 + " and "+ str2 +" is : "
                + getLevenshteinDistance(str1, str2));

        str1="1";
        str2="1";
        System.out.println("Levenshtein Distance of " +  str1 + " and "+ str2 +" is : "
                + getLevenshteinDistance(str1, str2));

        str1="1";
        str2="123456";
        System.out.println("Levenshtein Distance of " +  str1 + " and "+ str2 +" is : "
                + getLevenshteinDistance(str1, str2));
    }

    private static int getLevenshteinDistance(String str1, String str2) {
        int big = (str1.length() > str2.length()) ? str1.length() : str2.length();
        int small = (str1.length() <= str2.length()) ? str1.length() : str2.length();

        String bigString = (str1.length() > str2.length()) ? str1 : str2;
        String smallString = (str1.length() <= str2.length()) ? str1 : str2;

        if (big == 0 || str1.equals(str2)) {
            return 0;
        }

        if (small == 0) {
            return big;
        }

        ++big;
        ++small;

        arrayToLookup = new int[big];
        arrayToCompute = new int[big];

        // initialize arrayToCompute first
        for (int column = 0; column < big; column++) {
            arrayToLookup[column] = column;
        }

        for (int row = 1; row < small; row++) {
            arrayToCompute[0] = arrayToLookup[0] + 1;

            for (int column = 1; column < big; column++) {
                if (smallString.charAt(row-1) == bigString.charAt(column-1)) {
                    arrayToCompute[column] = arrayToLookup[column-1];
                } else {
                    arrayToCompute[column] = 1 + getMin(column);
                }
            }
            swapArrays();
        }

        return arrayToLookup[big-1];
    }

    private static void swapArrays() {
        int[] temp = arrayToCompute;
        arrayToCompute = arrayToLookup;
        arrayToLookup = temp;
    }

    private static int getMin(int column) {
        int min = arrayToCompute[column-1];
        min = (min<arrayToLookup[column])? min : arrayToLookup[column];
        min = (min<arrayToLookup[column-1])? min : arrayToLookup[column-1];
        return min;
    }

}
