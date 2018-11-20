package com.yogeesh.problemsolving.general;

/**
 * @author yogeesh.srkvs@gmail.com
 */

// Yet to correct

public class RemoveRecurringCharacters {

    public static String removeRepeatedCharacters(String string) {
        char[] characters = new char[string.length()];
        characters = string.toCharArray();

        int start = 0, cur = start;

        while (cur < characters.length) {

            int temp = cur;

            while (cur + 1 < characters.length && string.charAt(cur) == string.charAt(cur + 1)) {
                characters[cur] = 129;
                characters[cur + 1] = 129;
                cur++;
            }

            if (temp != cur) {
                cur++;
                while (cur != characters.length) {
                    characters[temp++] = characters[cur++];
                }
                cur = start;
                continue;
            }

            cur++;
        }

        System.out.println(characters);

        return "";
    }

    public static void main(String[] args) {
        String test = "azzzxxxxabby";
        RemoveRecurringCharacters.removeRepeatedCharacters(test);


    }
}
