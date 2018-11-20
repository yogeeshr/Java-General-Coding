package com.yogeesh.problemsolving.general;

/**
 * @author yogeesh.srkvs@gmail.com
 */

import java.util.ArrayList;
import java.util.List;

public class StringReplace {

    private static void printChangedString(String xyz) {
        char[] data = xyz.toCharArray();
        List<Character> temporaryString = new ArrayList<>();

        int start = temporaryString.size(), current = 0, end = temporaryString.size();

        while (current != start) {
            if (temporaryString.get(current) == 'a' && temporaryString.get(current + 1) != 'b') {
                current++;
                continue;
            }

            if (temporaryString.get(current) == 'a' && temporaryString.get(current + 1) == 'b') {
                current += 2;
                temporaryString.add((end + 1) % temporaryString.size(), 'a');
                temporaryString.add((end + 1) % temporaryString.size(), 'b');
                continue;
            }

            if (temporaryString.get(current) == 'b') {
                current++;
                temporaryString.add((end + 1) % temporaryString.size(), 'b');
                temporaryString.add((end + 1) % temporaryString.size(), 'b');
                continue;
            }
        }
    }

    public static void main(String[] args) {
        String xyz = "aaaabaababa";

        // a with nothing, b with bbb, ab with ab

        StringReplace.printChangedString(xyz);
    }

}
