package com.yogeesh.problemsolving.general;

/**
 * @author yogeesh.srkvs@gmail.com
 */

import java.util.ArrayList;
import java.util.List;

// Yet to correct

public class ReplaceStringChar {

    public static void changeData(List<Character> str, int length) throws IllegalStateException {

        if (str.size() == 0 || length <= 0) {
            new IllegalStateException("String empty");
        }

        int start = str.size(), end = str.size(), cur = 0;

        while (cur != start) {

            if (str.get(cur) == 'b') {

                str.add(end, 'b');
                end = (end + 1) % length;
                System.out.println(end);

                str.add(end, 'b');
                end = (end + 1) % length;
                System.out.println(end);

                str.add(end, 'b');
                end = (end + 1) % length;
                System.out.println(end);

                cur = cur + 1;
                continue;
            }

            if (cur + 1 == start) {
                if (str.get(cur) == 'a') {
                    cur = cur + 1;
                    continue;
                }
            }

            if (str.get(cur) == 'a') {

                System.out.println("hit");

                if (str.get(cur + 1) == 'b') {
                    System.out.println("hit1");
                    str.add(end, 'a');
                    end = (end + 1) % length;


                    str.add(end, 'b');
                    end = (end + 1) % length;
                    System.out.println(end);

                    cur = cur + 2;
                    continue;
                }

                cur = cur + 1;
                continue;
            }

        }

        int i = start;

        System.out.println("Start : " + start);

        System.out.println("");

        System.out.println(str + " test");

        while (i != end) {
            System.out.println(str.get(i));
            i = (i + 1) % (str.size());
        }

    }


    public static void changeDataInPlace(List<Character> str, int length) throws IllegalStateException {

        if (str.size() == 0 || length <= 0) {
            new IllegalStateException("String empty");
        }

        int start = str.size(), end = str.size(), cur = 0, curIterator = 0, actualStart = 0;

        while (curIterator != start) {
            if (str.get(curIterator) == 'a' && (str.get(curIterator + 1) == 'a' || curIterator + 1 == start)) {
                if (curIterator == start) {
                    start++;
                    cur = start + 1;
                }
                curIterator++;
                continue;
            }

            if (str.get(curIterator) == 'a' && str.get(curIterator + 1) != 'b' && curIterator + 1 != start) {
                str.add(cur, 'a');
                str.add(cur + 1, 'b');
                cur = cur + 2;
                curIterator += 2;
                continue;
            }

            if (str.get(curIterator) == 'b' && curIterator + 1 != start && curIterator + 2 != start) {
                str.add(end, str.get(cur));
                str.add((end + 1) % str.size(), str.get(cur + 1));
                end = (end + 2) % str.size();

                str.add(cur, 'b');
                str.add(cur + 1, 'b');
                str.add(cur + 2, 'b');
                curIterator += 3;
                cur += 3;
                continue;
            }
        }

        for (int i = start; i < (end + 1) % str.size(); i = (i + 1) % str.size()) {

            if (str.get(i) == 'a' && str.get((i + 1) % str.size()) == 'b') {
                str.add(cur, 'a');
                cur = (cur + 1) % str.size();

                str.add(cur, 'b');
                cur = (cur + 1) % str.size();

                i = (i + 1) % str.size();

                continue;
            }

            if (str.get(i) == 'b') {
                str.add(cur, 'b');
                cur = (cur + 1) % str.size();

                str.add(cur, 'b');
                cur = (cur + 1) % str.size();

                str.add(cur, 'b');
                cur = (cur + 1) % str.size();

                i = (i + 1) % str.size();

                continue;
            }
        }

        return;
    }

    public static void main(String[] args) {
        List<Character> data = new ArrayList<Character>();

        data.add('a');
        data.add('a');
        data.add('a');
        data.add('a');
        data.add('b');
        data.add('a');
        data.add('b');

        System.out.println(data + " test");

        ReplaceStringChar.changeData(data, 11);
    }

}
