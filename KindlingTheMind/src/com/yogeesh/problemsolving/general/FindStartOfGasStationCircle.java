package com.yogeesh.problemsolving.general;

import java.util.Objects;

/**
 * @author yogeesh.srkvs@gmail.com
 */

// Problem : https://www.interviewbit.com/problems/gas-station/
public class FindStartOfGasStationCircle {

    // Method to get start pointer of gas station with which we can make circle
    public static int getStationWithCircle(int[] fuel, int[] distanceToNext) {

        if (Objects.isNull(fuel) || Objects.isNull(distanceToNext) || fuel.length == 1) {
            return 0;
        }

        int start = 0, fuel_now = fuel[0], i = 1;

        while (true) {

            int newFuelRemaining = fuel_now + fuel[i] - distanceToNext[i];

            // Remove fuel if turning negative and increment start by deQueue
            while (start != i && (newFuelRemaining <= 0)) {
                start = (start + 1) % fuel.length;
                newFuelRemaining = fuel_now + fuel[i] + distanceToNext[start] - fuel[start];
            }

            // got the cycle
            if (((i + 1) % fuel.length) == start) {
                break;
            }

            fuel_now = newFuelRemaining;
            i = (i + 1) % fuel.length;

            System.out.println("Start :" + start + " | Fuel Remaining : " + fuel_now + " | I : " + i);
        }

        // No cycle-able index found
        if (start == 0 && fuel_now < 0) {
            return -1;
        }

        return start;

    }

    public static void main(String[] args) {
        int[] fuel = {1, 0, 3, 4, 5}, distanceToNext = {1, 2, 3, 4, 5};
        System.out.println(FindStartOfGasStationCircle.getStationWithCircle(fuel, distanceToNext));
    }

}
