package com.yogeesh.problemsolving.general;

/**
 * @author yogeesh.srkvs@gmail.com
 */

import java.util.*;

/*

There are N shops in a street. Each shop has 3 items X, Y, Z. Prices of the items are provided to you. You start from one end of the street and visit each shop till you reach the end of the street.
From each of the shops you need to buy exactly 1 item (X, Y, or Z). However, you can not buy the same item from adjacent shops.
What is the minimum total cost possible after having bought the N items?

Example:-
X => 1     2     1
Y => 50   50    50
Z => 40   20    30

Min Cost => Buy in this order X(1) + Z(20) + X(1)

X => 6     1     1
Y => 50   50    50
Z => 8    20     8

Min Cost => Z(8) + X(1) + Z(8)

*/

/**
 * Code Output
 *
 * Hello world - Java!
 * Min cost is 17
 */

// TODO : This is 3^N solution | N^3 can be done by changing recursion to DP

public class GivenNShopsChooseItem {

    public static void main(String args[]) {
        System.out.println("Hello world - Java!");

        int[][] cost = {
                {6, 50, 8},
                {1, 50, 20},
                {1, 50, 8}
        };

        System.out.println( "Min cost is " +  getMinCost(cost) );

    }

    /**
     * Main method getting min cost
     * @param cost
     * @return
     */
    public static int getMinCost(int[][] cost) {

        int sum0 = getCost(0, 0, cost, 0);
        int sum1 = getCost(0, 1, cost, 0);
        int sum2 = getCost(0, 2, cost, 0);

        int min = getMin(sum0, sum1, sum2);

        return min;

    }

    /**
     * Get min of 3 numbers
     * @param x
     * @param y
     * @param z
     * @return
     */
    public static int getMin(int x, int y, int z) {

        if (x< y && y<z) {
            return x;
        } else if (y<z) {
            return y;
        } else {
            return z;
        }

    }

    /**
     * Get min ina array list
     * @param list
     * @return
     */
    public static int getMinInArrayList(List<Integer> list) {

        int min = -1;

        for (int x: list) {
            if (x<min || min==-1) {
                min=x;
            }
        }

        return min;

    }

    /**
     * Recursive method to get min cost
     * @param row
     * @param col
     * @param cost
     * @param sum
     * @return
     */
    public static int getCost(int row, int col, int[][] cost, int sum) {

        // I am at last row
        if (row>=cost.length) {
            return 0;
        }

        List<Integer> tempSum = new ArrayList<>();

        for (int i=0; i<cost[row].length; i++) {

            if(i!=col) {
                tempSum.add( getCost(row+1, i, cost, 0) + cost[row][col] );
            }
        }

        return (getMinInArrayList(tempSum));
    }
}
