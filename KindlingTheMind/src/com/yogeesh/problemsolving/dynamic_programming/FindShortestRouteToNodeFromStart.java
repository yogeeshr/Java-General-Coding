package com.yogeesh.problemsolving.dynamic_programming;

/**
 * Created by yogeesh.srkvs@gmail.com on 8/15/17.
 */
public class FindShortestRouteToNodeFromStart {

    /**
     * Minimum of 3 numbers . . .
     *
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int min(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        }

        if (b < c) {
            return b;
        }

        return c;
    }

    /**
     * Find Minimum cost of reaching a node
     *
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    public static int minCost(int[][] matrix, int row, int col) {

        if (row < 0 || col < 0) {
            //Integer Max
            return 2137483647;
        }

        if (row == 0 && col == 0) {
            return matrix[row][col];
        }

        int diagonalPrev = minCost(matrix, row - 1, col - 1);
        int left = minCost(matrix, row - 1, col);
        int up = minCost(matrix, row, col - 1);

        int minNeighbour = min(diagonalPrev, left, up);

//        if (minNeighbour==diagonalPrev) {
//            System.out.print("("+(row-1)+", "+(col-1)+")\t");
//        } else if (minNeighbour==left) {
//            System.out.print("("+(row-1)+", "+(col)+")\t");
//        } else if (minNeighbour==up) {
//            System.out.print("("+(row)+", "+(col-1)+")\t");
//        }

        return (matrix[row][col] + minNeighbour);
    }

    public static void main(String[] args) {

        int[][] matrix = {{0, 2, 1, 3, 4},
                {1, 7, 1, 8, 9},
                {1, 10, 11, 12, 13},
                {14, 15, 16, 17, 18},
                {20, 21, 22, 23, 24}
        };

        int rows = 5, cols = 5;

        System.out.println("Matrix is : ");
        System.out.println("- - - ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("- - - ");

        System.out.println("\n- - - - -\nMinimum cost is (0,0) --> (3,3) " + minCost(matrix, 3, 3) + "\n- - - - -\n");

    }

}
