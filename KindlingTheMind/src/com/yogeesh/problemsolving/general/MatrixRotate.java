package com.yogeesh.problemsolving.general;

/**
 * Created by yogeesh.srkvs@gmail.com on 8/9/17.
 * Anti clock wise 90 degree matrix rotation
 */

public class MatrixRotate {
    public static void main(String[] args) {
        int[][] mat = { {0,0,0,0},
                        {6,1,1,1},
                        {2,2,2,2},
                        {3,3,3,3}
                    };


        int rows=4, cols=4;

        for (int i=0; i<rows/2; i++) {
            for (int j=i; j<rows-i-1; j++) {
                int n=rows;
                int temp1 = mat[i][j];
                int temp2 = mat[n-j-1][i];
                int temp3 = mat[n-i-1][n-j-1];
                int temp4 = mat[j][n-i-1];

                System.out.println("========");
                System.out.println("Rotating nodes :");
                System.out.println("========");
                System.out.print("("+i+","+j+")\t");
                System.out.print("("+(n-j-1)+","+i+")\t");
                System.out.print("("+(n-i-1)+","+(n-j-1)+")\t");
                System.out.println("("+j+","+(n-i-1)+")");
                System.out.print("========");
                System.out.println("");

                System.out.println("Elements : "+temp1+"\t"+temp2+"\t"+temp3+"\t"+temp4);

                // Change this part if it is clock wise and also if degree is 270 etc..
                mat[n-j-1][i]=temp1;
                mat[n-i-1][n-j-1]=temp2;
                mat[j][n-i-1]=temp3;
                mat[i][j]=temp4;

//                mv (i,j) --> (n-j+1, i)
//                mv (n-j+1, i) --> (n-i+1, n-i+1)
//                mv (n-i+1, n-j+1) --> (j, n-i+1)
//                mv (j, n-i+1) --> (i, j)
//                for (int il=0; il<rows; il++) {
//                    for (int jl=0; jl<cols; jl++) {
//                        System.out.print(mat[il][jl]+"\t");
//                    }
//                    System.out.println("");
//                }

            }

            System.out.println("Elements rotation interim matrix");
            for (int il=0; il<rows; il++) {
                for (int jl=0; jl<cols; jl++) {
                    System.out.print(mat[il][jl]+"\t");
                }
                System.out.println("");
            }

        }

        System.out.println("");
        System.out.println("Resultant matrix");
        for (int il=0; il<rows; il++) {
            for (int jl=0; jl<cols; jl++) {
                System.out.print(mat[il][jl]+"\t");
            }
            System.out.println("");
        }

    }
}
