package com.yogeesh.problemsolving.general;

import java.util.Stack;

/**
 * @author yogeesh.srkvs@gmail.com
 *
 * Stack item element
 */
class StackItem {
    int counter=0;
    char ele;

    StackItem(int counter, char ele) {
        this.counter = counter;
        this.ele = ele;
    }
}

public class RepetitiveCharacterBlast {

    /**
     * Magical function to print minimized string
     * @param charArray
     * @param thresholdOfBlast
     */
    public static void blastRepetitiveCharacters(Character[] charArray, int thresholdOfBlast) {
        Stack<StackItem> stack = new Stack<>();

        int i=0, length=charArray.length;

        while (i<length) {

            if (stack.isEmpty() || stack.peek().ele != charArray[i]) {
                stack.add(new StackItem(1, charArray[i]));
                ++i;
                continue;
            }

            if (stack.peek().ele == charArray[i]) {
                StackItem stackItem = stack.pop();
                stackItem.counter++;
                stack.add(stackItem);
            }

            if (stack.peek().counter>=thresholdOfBlast) {
                while (i<length && charArray[i]==stack.peek().ele) {
                    ++i;
                }
                stack.pop();
                continue;
            }

            ++i;
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()) {
            StackItem stackItem = stack.pop();
            stringBuilder.append( " " + stackItem.counter + "," + stackItem.ele );
            stringBuilder.reverse();
        }

        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        Character[] charArray = {'a', 'b', 'b', 'b' , 'a', 'd', 'd', 'e'};

        blastRepetitiveCharacters(charArray, 3);
    }
}
