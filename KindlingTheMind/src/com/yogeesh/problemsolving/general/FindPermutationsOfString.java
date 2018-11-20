package com.yogeesh.problemsolving.general;

import java.util.Scanner;


/**
 * @author yogeesh.srkvs@gmail.com
 */
public class FindPermutationsOfString {

    public static void swap(StringBuffer str, int i, int j) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }

    public static void permute(StringBuffer str, int leastIndex) {
        //recursion terminating condition
        if (leastIndex == str.length() - 1) {
            System.out.println(str);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            swap(str, leastIndex, i);
            FindPermutationsOfString.permute(str, leastIndex + 1);
            swap(str, leastIndex, i); //setting string back to how it was
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter String to permute");
        StringBuffer string = new StringBuffer(in.nextLine());
        in.close();
        FindPermutationsOfString.permute(string, 0);
    }

}
