package com.yogeesh.problemsolving.general;

/**
 * @author yogeesh.srkvs@gmail.com
 */

public class SearchElementInSortedMatrix {

    public static boolean isNumberExists(int[][] matrix, int ele) {
        int cols = matrix[0].length, rows = matrix.length, k = 0, m = (matrix[0].length - 1);

        while (true) {
            if (k >= rows || m >= cols) {
                return false;
            }

            if (matrix[k][m] == ele) {
                System.out.println("Found element [ " + k + " ] [ " + m + " ]");
                return true;
            }

            if (matrix[k][m] > ele) {
                --m;
                continue;
            }

            if (matrix[k][m] < ele) {
                ++k;
            }
        }

    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int[] bounds = {0, 0, matrix.length, matrix[0].length};
        String appender = (!(isNumberExists(matrix, 99)) ? "not " : "");
        System.out.println(" Element does " + appender + "exist in matrix");
    }
}

