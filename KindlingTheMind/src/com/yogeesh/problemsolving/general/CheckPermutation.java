package com.yogeesh.problemsolving.general;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yogeesh.srkvs@gmail.com
 */

public class CheckPermutation {

    //yet to complete

    private static int getPermutationOf(String inputString, String patternToSearch) {

        int patternToSearchLength = patternToSearch.length();
        int inputStringLength = inputString.length();
        int start = -1;

        Set<Character> foundChar = new HashSet<>();

        for (int i = 0; i < inputStringLength; i++) {
            int tempStart = i, j = 0;

            //check for pattern
            while (isValid(i, inputString, patternToSearch) &&
                    !foundChar.contains(inputString.charAt(i))) {
                foundChar.add(inputString.charAt(i));
                ++i;
            }

            // check if we found.
            if (foundChar.size() == patternToSearchLength) {
                start = tempStart;
                return start;
            }
        }

        return -1;
    }

    // Check validity of iteration
    public static boolean isValid(int i, String inputString, String patternToSearch) {
        char element = inputString.charAt(i);
        if (i > inputString.length() - 1 || !patternToSearch.contains(element + "")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "SFAEBCDKLS", pattern = "ABCDEF";
        System.out.println("Start is :" + getPermutationOf(input, pattern));
    }
}
