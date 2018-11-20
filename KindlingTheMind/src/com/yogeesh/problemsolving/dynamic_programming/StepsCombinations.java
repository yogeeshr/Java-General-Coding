package com.yogeesh.problemsolving.dynamic_programming;

/**
 * @author yogeesh.srkvs@gmail.com
 */
public class StepsCombinations {

    static int getNumberOfWays(int stepsCount) {

        if (stepsCount == 1) {
            return 1;
        }

        if (stepsCount == 2) {
            return 2;
        }

        int stepsCountOneLess = getNumberOfWays(stepsCount - 1);
        int stepsCountTwoLess = getNumberOfWays(stepsCount - 2);

        return stepsCountOneLess + stepsCountTwoLess;
    }

    public static void main(String[] args) {
        // Recursion : Time O(2^n)
        System.out.println(StepsCombinations.getNumberOfWays(5));

        int steps = 5, stepBackToBack = 1, stepBack = 2, currentStep = 0;

        for (int i = 3; i <= steps; i++) {
            currentStep = stepBack + stepBackToBack;
            stepBackToBack = stepBack;
            stepBack = currentStep;
        }

        System.out.println("DP Approach : StepsCombinations.getNumberOfWays " + currentStep);
    }

}

