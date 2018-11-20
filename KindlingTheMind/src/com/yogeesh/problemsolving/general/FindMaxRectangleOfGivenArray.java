package com.yogeesh.problemsolving.general;

import java.util.Stack;

/**
 * Created by yogeesh.srkvs@gmail.com on 8/15/17.
 */

class Result {
    int start, end, area;
}

public class FindMaxRectangleOfGivenArray {

    static Result result = new Result();

    public static Result getMaxRectangle(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, n = arr.length, maxArea = -1;

        while (i < n) {
            if (stack.empty() || arr[stack.peek()] <= arr[i]) {
                stack.push(i);
                ++i;
            } else {
                int top = stack.peek();
                stack.pop();

                int size = ((stack.empty()) ? i : (i - stack.peek() - 1));
                int tempArea = arr[top] * size;

                if (tempArea > maxArea) {
                    maxArea = tempArea;
                    result.area = maxArea;
                    result.end = i - 1;
                    result.start = stack.peek() + 1;
                }
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.peek();
            stack.pop();

            int size = ((stack.empty()) ? i : (i - stack.peek() - 1));
            int tempArea = arr[top] * size;

            if (tempArea > maxArea) {
                maxArea = tempArea;
                result.area = maxArea;
                result.end = i - 1;
                result.start = stack.peek() + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 5, 6, 7, 7, 5, 4, 3, 1, 1};
        Result result = FindMaxRectangleOfGivenArray.getMaxRectangle(array);
        System.out.println("Max area is : " + result.area);
        System.out.println("Max area Start is : " + result.start);
        System.out.println("Max area End is : " + result.end);

    }

}
