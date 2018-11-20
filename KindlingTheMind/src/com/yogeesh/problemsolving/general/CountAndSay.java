package com.yogeesh.problemsolving.general;

/**
 * @author yogeesh.srkvs@gmail.com
 */

public class CountAndSay {

    int data = 1;

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(7));
    }

    public int countAndSay(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 11;
        }

        data = 11;

        for (int i = 2; i < n; i++) {
            int length = Integer.toString(data).length(), j = 0, counter = 1;
            String temp = Integer.toString(data), result = "";

            char prev = temp.charAt(0);
            ++j;

            while (j < length) {

                //if runnning element
                if (prev == temp.charAt(j)) {
                    ++counter;
                } else {
                    result = result + counter + prev;
                    prev = temp.charAt(j);
                    counter = 1;
                }

                j++;

            }

            result = result + counter + prev;
            data = Integer.valueOf(result);

        }

        return data;

    }

}
