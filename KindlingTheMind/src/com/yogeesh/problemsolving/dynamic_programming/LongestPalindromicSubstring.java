package com.yogeesh.problemsolving.dynamic_programming;

/**
 * Created by yogeesh.srkvs@gmail.com on 8/7/17.
 */
public class LongestPalindromicSubstring {

    static int maxLength=-1, start=-1;

    /**
     * Method to get longest palindromic substring
     * @param a
     */
    public static void getLongestPalindrome(char[] a) {

        int leftBound=0, rightBound=0;

        for (int i=0;i<a.length; i++) {

            // Odd length palindrome
            leftBound=i-1;
            rightBound=i+1;
            int length=0;
            while (leftBound>=0 && rightBound<a.length && a[leftBound]==a[rightBound]) {
                if (maxLength < (rightBound-leftBound+1)) {
                    maxLength = (rightBound-leftBound+1);
                    start = leftBound;
                }
                --leftBound;
                ++rightBound;
            }

            // Even length palindrome
            leftBound=i-1;
            rightBound=i;
            length=0;
            while (leftBound>=0 && rightBound<a.length && a[leftBound]==a[rightBound]) {
                if (maxLength < (rightBound-leftBound+1)) {
                    maxLength = (rightBound-leftBound+1);
                    start = leftBound;
                }
                --leftBound;
                ++rightBound;
            }

        }
    }

    public static void main(String[] args) {
        String input = "yogeesh";
        char[] array = input.toCharArray();
        LongestPalindromicSubstring.getLongestPalindrome(array);

        System.out.println("String is : "+input);
        System.out.print("Longest palindromic sub string is : ");
        for (int i=0; i<maxLength; i++) {
            System.out.print(array[start+i]+"");
        }
        System.out.print("Longest palindromic sub string length is : "+maxLength);
        System.out.print("Longest palindromic sub string start index is : "+start);
    }
}
