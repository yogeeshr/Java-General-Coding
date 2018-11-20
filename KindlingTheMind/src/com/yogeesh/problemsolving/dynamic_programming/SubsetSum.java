package com.yogeesh.problemsolving.dynamic_programming;

/**
 * @author yogeesh.srkvs@gmail.com
 */

public class SubsetSum {

    public static void getSubsetSum(int[] arr, int sum) {

        if (arr.length == 0 || sum < 0) {
            return;
        }

        // provided sum is less then 2 power n
        boolean[][] matrix = new boolean[arr.length][sum + 1];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = true;
        }

        System.out.print("-\t");
        for (int j = 1; j < matrix[0].length; j++) {
            System.out.print(j + "\t");
            matrix[0][j] = (arr[0] > j || arr[0] < j) ? false : true;
        }

        System.out.println("");

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = (arr[i] > j) ? matrix[i - 1][j] : (matrix[i - 1][j] || matrix[i - 1][j - arr[i]]);
            }
        }


        System.out.println("");
        System.out.println("Resultant matrix : ");

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(arr[i] + "\t");
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]) {
                    System.out.print("T\t");
                } else {
                    System.out.print("F\t");
                }
            }
            System.out.println("");
        }

        System.out.println("");
        System.out.println("Elements are : ");

        if (!matrix[matrix.length - 1][matrix[0].length - 1]) {
            System.out.println("NO ELEMENTS FORM THE SUM GIVEN AS INPUT");
        }

        int i = matrix.length - 1, j = matrix[0].length - 1;


        while (i > 0 && j > 0) {
            if (matrix[i - 1][j]) {
                i--;
                continue;
            }

            if (matrix[i][j] && matrix[i][j - arr[i]]) {
                System.out.print(arr[i] + " | ");
                j = j - arr[i];
                continue;
            }
        }

    }

    public static void main(String[] args) {
        int[] number = {2, 8, 7, 3, 10};
        int sum = 11;

        SubsetSum.getSubsetSum(number, sum);
    }
}
