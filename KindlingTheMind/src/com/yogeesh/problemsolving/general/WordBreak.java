package com.yogeesh.problemsolving.general;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yogeesh.srkvs@gmail.com on 8/17/17.
 */

public class WordBreak {

    public static Set<String> dictSet = new HashSet<>();

    static {
        dictSet.add("a");
        dictSet.add("am");
        dictSet.add("i");
        dictSet.add("like");
        dictSet.add("google");
        dictSet.add("inmobi");
    }

    public static void getMeStatementWithSpace(String str, int length, String result) {

        //Process all prefixes one by one
        for (int i = 1; i <= str.length(); i++) {
            String prefix = str.substring(0, i);

//            System.out.println("Prefix is : "+prefix);

//            System.out.println(result+" ");

            // if dictonary has to index in it , check for rest of string chunks
            if (dictSet.contains(prefix)) {
                // if no more elements are there, print it
                if (i == length) {
                    // add this element to previous prefix
                    result += prefix;
                    System.out.println("Result : " + result + " ");
                    return;
                }

                String result1 = result + prefix + " ";
//                System.out.println("i :"+i);
//                System.out.println("length :"+length);
//                System.out.println("String is : "+str);
                String str1 = str.substring(i, length);
//                System.out.println("Sub String is : "+str1);
                getMeStatementWithSpace(str1, str1.length(), result1);
            }
        }

    }

    public static void main(String[] args) {
        WordBreak.getMeStatementWithSpace("ilikeinmobi", "ilikeinmobi".length(), "");
    }

}
