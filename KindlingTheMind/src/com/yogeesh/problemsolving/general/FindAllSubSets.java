package com.yogeesh.problemsolving.general;

/**
 * @author yogeesh.srkvs@gmail.com
 *
 */
public class FindAllSubSets {

    public static void main(String []args) {
        int array[] = {1,2,3};
        System.out.println("SubSets are :");

        FindAllSubSets.print(array);

    }

    private static void print(int[] array) {

        double possibleCombinations = Math.pow(2, array.length);

        //By number theory I know that for given set of n elements there are  2 power n subset
        for (int i=0; i<possibleCombinations; i++) {
            System.out.print("{ ");
            for (int j=0; j<array.length; j++) {
                if ( ((int)Math.pow(2, j) & i) != 0 ) {
                    /**
                     * which ever bit is set while going one by one from 0 to 2 power n in each numbers
                     * print those array elements
                     */
                    System.out.print(array[j]+" ");
                }
            }
            System.out.println("} ");
        }

    }
}