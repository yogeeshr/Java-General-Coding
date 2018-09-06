package com.yogeesh.problemsolving.general;

import java.util.Stack;

/**
 * Created by yogeesh.srkvs@gmail.com on 8/15/17.
 */

public class FindMaxRectangleOfGivenArray {

    public static int getMaxRectangle(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int i=0, n=arr.length, maxArea=-1;

        while (i<n) {
            if (stack.empty() || arr[stack.peek()]<=arr[i]) {
                stack.push(i);
                ++i;
            } else {
                int top = stack.peek();
                stack.pop();

                int tempArea = arr[top] * ((stack.empty())? i: (i - stack.peek()-1) ) ;

                if (tempArea > maxArea) {
                    maxArea = tempArea;
                }
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.peek();
            stack.pop();

            int tempArea = arr[top] * ((stack.empty())? i: (i - stack.peek()-1) ) ;

            if (tempArea > maxArea) {
                maxArea = tempArea;
            }
        }

        return maxArea;
    }

    public static void main(String []args) {
        int[] array = {1,2,3,4,5,6,7,7,5,4,3,1,1};
        int area = FindMaxRectangleOfGivenArray.getMaxRectangle(array);
        System.out.println("Max area is : "+area);

    }

}
