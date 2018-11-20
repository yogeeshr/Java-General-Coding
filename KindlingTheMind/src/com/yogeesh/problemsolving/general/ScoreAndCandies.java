package com.yogeesh.problemsolving.general;

/**
 * @author yogeesh.srkvs@gmail.com
 */

//yet to correct

public class ScoreAndCandies {

    public static int[] getCandiesToDistribute(int[] scores) throws IllegalStateException {

        // assume all scores are non negative and non zero
        if (scores.length <= 0) {
            throw new IllegalStateException("Scores less in length");
        }

        int[] candies = new int[scores.length];

        for (int i = 0; i < candies.length; i++) {
            candies[i] = -1;
        }

        // Increasing sequences . . .
        for (int i = 0; i < candies.length; i++) {
            while (i < candies.length - 1 && scores[i] < scores[i + 1]) {
                if (candies[i] == -1) {
                    candies[i] = 1;
                }
                candies[i + 1] = candies[i] + 1;
                ++i;
            }
        }

        // Decreasing sequences . . .
        for (int i = candies.length - 1; i > 0; i--) {
            while (i > 0 && scores[i] < scores[i - 1]) {
                if (candies[i] == -1) {
                    candies[i] = 1;
                }
                candies[i - 1] = candies[i] + 1;
                --i;
            }
        }

        // Increasing same numbered sequences . . .
        for (int i = 0; i < candies.length; i++) {
            while (i < candies.length - 1 && scores[i] == scores[i + 1]) {
                if (candies[i] == -1) {
                    ++i;
                    continue;
                }
                candies[i + 1] = candies[i];
                ++i;
            }
        }

        // Decreasing same numbered sequences . . .
        for (int i = candies.length - 1; i > 0; i--) {
            while (i > 0 && scores[i] == scores[i - 1]) {
                if (candies[i] == -1) {
                    --i;
                    continue;
                }
                candies[i - 1] = candies[i];
                --i;
            }
        }

        // If all same number ....
        for (int i = candies.length - 1; i >= 0; i--) {
            if (candies[i] == -1) {
                candies[i] = 1;
            }
        }


        return candies;

    }

    public static void main(String[] args) {
//        int[] scores = {5, 5, 5, 5, 4, 3, 2, 1, 5, 4, 1, 2, 3, 4, 5, 5};

        int[] scores = {6, 5, 5, 5, 5, 1};

        int[] candies = ScoreAndCandies.getCandiesToDistribute(scores);

        for (int i = 0; i < candies.length; i++) {
            System.out.println(scores[i] + " | " + candies[i]);
        }

        System.out.println();
    }
}
