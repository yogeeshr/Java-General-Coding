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

                // to handle condition like 1, 2, 3, 4, 3, 2 ----- here 4 should get 4 candies from increasing
                // sequence than 3 candies due to decreasing sequence
                if (candies[i - 1] < candies[i] + 1) {
                    candies[i - 1] = candies[i] + 1;
                }

                --i;
            }
        }

        // Same score
        for (int i = candies.length - 1; i > 0; i--) {
            int start=-1, end=-1;

            if(scores[i] != scores[i - 1]) {
                continue;
            }

            while (i>0 && scores[i] == scores[i - 1]) {
                if (end == -1) {
                    end = i;
                }
                --i;
            }

            start=i;

            int candiesSame=-1;

            if (candies[start]>candies[end]) {
                candiesSame=candies[start];
            } else {
                candiesSame=candies[end];
            }

            candiesSame = (candiesSame!=-1)? candiesSame: 1;

            i=start;

            while (i!=end+1) {
                candies[i]=candiesSame;
                ++i;
            }

            i=start-1;
        }

        return candies;

    }

    public static void main(String[] args) {
//        int[] scores = {5, 5, 5, 5, 4, 3, 2, 1, 5, 4, 1, 2, 3, 4, 5, 5};

        int[] scores = {6, 6, 6, 6, 6, 10, 9 , 8, 11, 2, 5, 7, 6, 5, 5, 5, 5, 1, 10, 10, 10, 10};

//        int[] scores = {1, 2, 3, 4, 5, 4, 3, 2, 1, 6, 7, 5, 5};

        int[] candies = ScoreAndCandies.getCandiesToDistribute(scores);

        for (int i = 0; i < candies.length; i++) {
            System.out.println(scores[i] + " | " + candies[i]);
        }

        System.out.println();
    }
}
