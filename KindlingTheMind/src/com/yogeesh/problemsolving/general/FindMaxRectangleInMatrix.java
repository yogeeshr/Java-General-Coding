package com.yogeesh.problemsolving.general;


// Yet to correct

class MatrixRectResult {
    int[] resultIndicies;
    int area;

    MatrixRectResult() {
        resultIndicies = new int[]{0, 0, 0, 0};
        area = -1;
    }
}

public class FindMaxRectangleInMatrix {

    public static MatrixRectResult getMaxRectangleArea(int[][] matrix) {

        MatrixRectResult matrixRectResult = new MatrixRectResult();

        if (matrix.length == 0 || matrix == null) {
            return matrixRectResult;
        }

        int rows = matrix.length, cols = matrix[0].length, maxArea = -1;
        int[] tempArray = new int[cols];

        for (int i = 0; i < cols; i++) {
            tempArray[i] = 0;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 1) {
                    tempArray[col]++;
                } else {
                    tempArray[col] = 0;
                }
            }
            Result result = FindMaxRectangleOfGivenArray.getMaxRectangle(tempArray);

            if (result.area > matrixRectResult.area) {
                matrixRectResult.area = result.area;

                // row col left top corner
                matrixRectResult.resultIndicies[0] = row - tempArray[result.start] + 1;
                matrixRectResult.resultIndicies[1] = result.start;

                // row col right end corner
                matrixRectResult.resultIndicies[2] = row;
                matrixRectResult.resultIndicies[3] = result.end;

            }
        }

        return matrixRectResult;

    }

    public static void main(String[] args) {
        int matrix[][] = {
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };

        MatrixRectResult matrixRectResult = FindMaxRectangleInMatrix.getMaxRectangleArea(matrix);

        System.out.println("Left top : " + matrixRectResult.resultIndicies[0] + " , " + matrixRectResult.resultIndicies[1]);
        System.out.println("Right Bottom " + matrixRectResult.resultIndicies[2] + " , " + matrixRectResult.resultIndicies[3]);

        System.out.println(matrixRectResult.area);
    }

}
