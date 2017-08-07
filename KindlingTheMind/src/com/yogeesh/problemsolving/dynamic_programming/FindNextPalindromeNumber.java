package com.yogeesh.problemsolving.dynamic_programming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yogeesh.srkvs@gmail.com on 8/6/17.
 *
 * Logic is
 * --> #1. if number is single digit and less than 1 next number is next palindrome
 * --> #2. if number is 9 then next palindrome is 11
 * --> #3. If 2 or more digits, copy first half to second half as ( reverse of first half )
 *  --> #3a. If odd number length, add 1 to middle element and propogate carry to right and left halves
 *  --> #3b. If even number length,  add 1 to left half and right half from middle and propogate carry
 */
public class FindNextPalindromeNumber {

    /**
     * Method to get next palindrome
     * @param number
     * @return
     */
    public static int getNextPalindrome(int number) {

        int nextPalindrome=0, backupNumber = number;

        // If single digit <9 then next palindrome is next number itself
        if (number<9) {
            nextPalindrome=number+1;
            return nextPalindrome;
        }

        // If number is 9 then next palindrome is 11
        if (number==9) {
            nextPalindrome=11;
            return nextPalindrome;
        }

        int numberLength=(number+"").length();

        String arr[] = new String[numberLength];

        int i=0;
        //Create string of integer
        while (number!=0) {
            arr[i++]=(number%10+"");
            number = number/10;
        }

        //Make array as list
        List<String> arrList = Arrays.asList(arr);

        // Reverse array elemnts of list
        Collections.reverse(arrList);

        arr = (String[]) arrList.toArray();

        String middle = "";
        String firstHalf = "";

        if (numberLength%2 != 0) {
            middle=arr[numberLength/2];
        }

        for (i=0; i<numberLength/2 ; i++) {
            firstHalf = firstHalf+arr[i];
        }

        String secondHalf="";

        char[] try1 = firstHalf.toCharArray();

        for (i = try1.length-1; i>=0; i--) {
            secondHalf=secondHalf+try1[i];
        }

        String nextPalindromeString = firstHalf+middle+secondHalf;

        System.out.println("Interm next palindrome :"+nextPalindromeString);
        System.out.println("First Half [Next Palindrome] :"+firstHalf);
        System.out.println("Second Half [Next Palindrome] :"+secondHalf);
        System.out.println("Middle :"+middle);

        if (Integer.parseInt(nextPalindromeString) <= backupNumber) {
            if ((numberLength%2 != 0)) {
                if (Integer.parseInt(middle)<9) {
                    middle=Integer.parseInt(middle)+1+"";
                } else if (Integer.parseInt(middle)==9) {
                    middle="0";
                    firstHalf = Integer.parseInt(firstHalf)+1+"";
                }
            } else {
                firstHalf = Integer.parseInt(firstHalf)+1+"";
            }
        }

        secondHalf="";
        try1 = firstHalf.toCharArray();
        for (i = try1.length-1; i>=0; i--) {
            secondHalf=secondHalf+try1[i];
        }

        nextPalindromeString = firstHalf+middle+secondHalf;
        return Integer.parseInt(nextPalindromeString);
    }

    public static void main(String[] args) {
        int number = 1929292, nextPalindrome=0;

        nextPalindrome= FindNextPalindromeNumber.getNextPalindrome(number);

        System.out.println(nextPalindrome);

    }
}
