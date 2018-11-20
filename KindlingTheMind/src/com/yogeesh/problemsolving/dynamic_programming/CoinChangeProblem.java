package com.yogeesh.problemsolving.dynamic_programming;

/**
 * @author yogeesh.srkvs@gmail.com
 */

public class CoinChangeProblem {

    public static int getWaysOfFormingDenomination(int[] coins, int denomination) throws IllegalStateException {

        if (coins.length <= 0) {
            throw new IllegalStateException("No coins");

        }

        if (denomination <= 0) {
            throw new IllegalStateException("Denomination equal or less than zero");

        }

        int[][] matrix = new int[coins.length + 1][denomination + 1];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row][0] = 1;
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if (col < coins[row - 1]) {
                    matrix[row][col] = matrix[row - 1][col];
                } else {
                    matrix[row][col] = matrix[row - 1][col] + matrix[row][col - coins[row - 1]];
                }
            }
        }


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        return matrix[matrix.length - 1][matrix[0].length - 1];

    }

    public static int getWaysSpaceEfficient(int coins[], int coinfLength, int n) {
        int runningSolution[] = new int[n + 1];

        runningSolution[0] = 1;

        for (int i = 0; i < coinfLength; i++)
            // for all coins index more than present coin
            for (int j = coins[i]; j <= n; j++)
                runningSolution[j] += runningSolution[j - coins[i]];

        for (int i = 0; i < runningSolution.length; i++) {
            System.out.print(runningSolution[i] + "");
        }
        return runningSolution[n];
    }

    public static int minNumberOfCoins(int coins[], int coinLength, int totalSum) {
        int runningSolution[] = new int[totalSum + 1];

        runningSolution[0] = 0;

        for (int i = 1; i <= totalSum; i++) {
            runningSolution[i] = Integer.MAX_VALUE;
        }

        // for all value from 1 till sum total
        for (int i = 1; i <= totalSum; i++) {
            // for all coins
            for (int j = 0; j < coinLength; j++) {
                if (i >= coins[j] && runningSolution[i] > 1 + runningSolution[i - coins[j]]) {
                    runningSolution[i] = 1 + runningSolution[i - coins[j]];
                }
            }
        }

        return runningSolution[totalSum];
    }


    public static void main(String[] args) {
        int[] coins = {3, 1, 2};
        int denomination = 5;

        int ways = CoinChangeProblem.getWaysOfFormingDenomination(coins, denomination);
        System.out.println(ways);

        ways = CoinChangeProblem.getWaysSpaceEfficient(coins, coins.length, denomination);
        System.out.println(ways);

        int minWays = CoinChangeProblem.minNumberOfCoins(coins, coins.length, denomination);
        System.out.println("Min Coins to Sum " + minWays);
    }
}
