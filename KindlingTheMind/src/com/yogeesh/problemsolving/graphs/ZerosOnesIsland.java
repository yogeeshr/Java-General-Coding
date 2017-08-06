package com.yogeesh.problemsolving.graphs;

/**
 * Created by yogeesh.srkvs@gmail.com on 8/6/17.
 * Classic visitor design pattern . . .
 * Concept : Connected graph
 */
public class ZerosOnesIsland {

    // Variables
    static int rows = 3, cols = 3, islands=0;

    // Visited flag
    static boolean visited[][] = new boolean[rows][cols];

    // Matrix
    static int [][] graphMatrix = {{0,0,0},
                        {1,1,1},
                        {0,1,0}};

    // Method to check safeness of traversal
    public static  boolean issafe(int a[][], int row, int col, boolean visited[][]) {

        /**
         * #1. element traversed should be 1
         * #2. row is within range of matrix (handling edge elements)
         * #3. col is within matric range (handling edge elements)
         * #4. element should not be visited before
         */
        return (    (   row>=0  && row<rows ) &&
                    (   col>=0 && col<cols  ) &&
                    (   a[row][col]==1      ) &&
                    (   !visited[row][col]  )
                );
    }

    // Method to do DFS of adjacent elements in matrix
    public static void dfs(int a[][], int row, int col, boolean visited[][]) {

        int rowAdj[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int colAdj[] = {0, -1, 1, 1, -1, 1, 0, -1};

        visited[row][col] = true;

        for (int i=0; i<8; i++) {
                if (issafe(a, row+rowAdj[i], col+colAdj[i], visited)) {
                    dfs(a, row+rowAdj[i], col+colAdj[i], visited);
                }
        }

        return;
    }

    public static void main(String[] args) {

        // Print Matrix
        System.out.println("Matrix is : ");
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                    System.out.print(graphMatrix[i][j]+"\t");
            }
            System.out.println();
        }

        // In the quest of islands
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (graphMatrix[i][j]==1 && !visited[i][j]) {
                    ZerosOnesIsland.dfs(graphMatrix, i, j, visited);
                    ++islands;
                }
            }
        }

        System.out.println("No of Islands : [ "+islands+" ]");

    }
}
