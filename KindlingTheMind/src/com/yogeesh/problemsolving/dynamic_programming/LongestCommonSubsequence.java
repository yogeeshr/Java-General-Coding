package com.yogeesh.problemsolving.dynamic_programming;

/**
 * Created by yogeesh.srkvs@gmail.com on 8/15/17.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String input1 = "aababbb", input2 = "aaabbbb", cs="";

        int[][] mat = new int[input1.length()+1][input2.length()+1];
        int rows = input1.length()+1;
        int cols = input2.length()+1;

        for (int i=0; i<rows; i++) {
            mat[i][0] = 0;
        }

        for (int j=0; j<cols; j++) {
            mat[0][j] = 0;
        }

        for (int i=1; i<rows; i++) {
            for (int j=1; j<cols; j++) {
                if (input1.charAt(i-1)==input2.charAt(j-1)) {
                    mat[i][j]=mat[i-1][j-1]+1;
                } else {
                    mat[i][j]=max(mat[i][j-1], mat[i-1][j]);
                }
            }
        }

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                System.out.print(mat[i][j]+"\t");
            }
            System.out.println();
        }

        // Traversal fom bottom right to left top
        for (int i=rows-1; i>=0; i--) {
            for (int j=cols-1; j>=0; j--) {
                if (i>0 && j>0 && mat[i][j]>mat[i][j-1] && mat[i][j]>mat[i-1][j] && mat[i][j]>mat[i-1][j-1]) {
                    cs = input1.charAt(i-1)+cs;
                    i=i-1;
                }
            }
            System.out.println();
        }

        System.out.println("Len : "+mat[rows-1][cols-1]);
        System.out.println("Longest common subsequence : "+cs);

    }

    /**
     * Methos to return max of two elements
     * @param i
     * @param i1
     * @return
     */
    private static int max(int i, int i1) {
        if (i>i1) {
            return i;
        } else {
            return i1;
        }
    }
}
