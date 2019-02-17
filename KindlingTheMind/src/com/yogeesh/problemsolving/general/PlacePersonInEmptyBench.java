package com.yogeesh.problemsolving.general;

import java.util.PriorityQueue;

/**
 * @author yogeesh.srkvs@gmail.com
 * Q : https://www.careercup.com/question?id=5385816814125056
 */

class Node implements Comparable {
    int start, end, gap;

    @Override
    public int compareTo(Object o) {
        Node node = (Node) o;

        if (this.gap > node.gap) {
            return -1;
        } else if (this.gap < node.gap) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class PlacePersonInEmptyBench {

    /**
     * Method to create heap out of benches and people seating arrangement
     *
     * @param priorityQueue
     * @param benchStatus
     */
    private static void createMaxHeap(PriorityQueue<Node> priorityQueue, boolean[] benchStatus) {

        int gap = 0, start = -1, end = Integer.MAX_VALUE;

        for (int i = 0; i < benchStatus.length; i++) {

            // If person sitting . . .
            if (benchStatus[i]) {

                Node node = new Node();
                node.start = start;
                node.end = i;
                end = i;

                if (start == -1) {
                    node.gap = node.end - 1;
                    priorityQueue.add(node);
                    start = end;
                    i = i + 1;
                    continue;
                }

                if (start + 1 == i) {
                    start = start + 2;
                    i = i + 1;
                    continue;
                }

                node.gap = ((i - start) / 2) - 1;
                priorityQueue.add(node);
                start = end;
                continue;

            }

            // If we reach end and no person sitting
            if (i == benchStatus.length - 1) {
                Node node = new Node();
                node.start = start;
                node.end = Integer.MAX_VALUE;
                node.gap = i - start - 1;
                priorityQueue.add(node);
            }

            //TODO : Cover case of all empty benches later

        }

    }

    /**
     * Add new incoming person
     * @param priorityQueue
     * @param benches
     */
    private static void addNewPerson(PriorityQueue<Node> priorityQueue, boolean[] benches) {

        if (priorityQueue.isEmpty()) {
            System.out.println("No empty bench");
        }

        Node node = priorityQueue.poll();

        // Node with large gap at start
        if (node.start == -1) {
            System.out.println("Person at position : 0");
            benches[0] = true;
            if (benches.length > 2 && !benches[1]) {
                node.start = 0;
                node.gap = ((node.end - node.start) / 2) - 1;
                priorityQueue.add(node);
                return;
            }
        }

        // Node with large gap at end
        if (node.end == Integer.MAX_VALUE) {

            System.out.println("Person at position : " + (benches.length - 1));

            benches[benches.length - 1] = true;

            if (benches.length > 2 && !benches[benches.length - 2]) {
                node.end = benches.length - 1;
                node.gap = ((node.end - node.start) / 2) - 1;
                priorityQueue.add(node);
                return;
            }

        }

        int position = node.start + node.gap + 1;
        System.out.println("Person placed at position :" + position);
        benches[position] = true;

        // Adding right gap, if present
        if (position + 1 != node.end) {
            Node tempNode = new Node();
            tempNode.start = position;
            tempNode.end = node.end;
            tempNode.gap = ((tempNode.end - tempNode.start) / 2) - 1;
            priorityQueue.add(tempNode);
        }

        // Adding left gap, if present
        if (node.start + 1 != position) {
            node.end = position;
            node.gap = ((node.end - node.start) / 2) - 1;
            priorityQueue.add(node);
        }

    }

    public static void main(String[] args) {
        boolean[] benchStatus = {false, false, false, false, true, false, false, false, true, false, true, false,
                false, false};

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        // Create MAX heap
        createMaxHeap(priorityQueue, benchStatus);

        addNewPerson(priorityQueue, benchStatus);
        addNewPerson(priorityQueue, benchStatus);
        addNewPerson(priorityQueue, benchStatus);
        addNewPerson(priorityQueue, benchStatus);
        addNewPerson(priorityQueue, benchStatus);
        addNewPerson(priorityQueue, benchStatus);

    }

    /**
     * Sample Output
     *
     * Person at position : 0
     * Person at position : 13
     * Person placed at position :2
     * Person placed at position :6
     * Person placed at position :1
     * Person placed at position :5
     *
     */

}
