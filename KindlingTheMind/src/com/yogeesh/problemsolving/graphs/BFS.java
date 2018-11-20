package com.yogeesh.problemsolving.graphs;

/**
 * @author yogeesh.srkvs@gmail.com
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static void bfs(int[] verticies, List edges, int src, int dstn) {

        if (edges.size() != verticies.length || src < 0 || dstn < 0
                || src >= verticies.length || dstn >= verticies.length) {
            System.out.println("ERROR");
            return;
        }

        if (src == dstn) {
            System.out.println("Source itself it destination");
            return;
        }

        boolean[] visited = new boolean[verticies.length];
        int[] path = new int[verticies.length];
        int[] dist = new int[verticies.length];

        for (int i = 0; i < verticies.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> queue = new LinkedList();
        queue.clear();
        ((LinkedList<Integer>) queue).add(src);
        dist[src] = 0;
        path[src] = -1;

        while (!queue.isEmpty()) {
            Integer vertex = ((LinkedList<Integer>) queue).getFirst();
            queue.remove();

            for (int tempVertex : (int[]) edges.get(vertex)) {
                if (visited[tempVertex]) {
                    continue;
                }
                visited[tempVertex] = true;
                queue.add(tempVertex);
                path[tempVertex] = vertex;
                dist[tempVertex] = dist[vertex] + 1;

                if (tempVertex == dstn) {
                    break;
                }
            }
        }

        if (path[dstn] == 0) {
            System.out.println("no path found");
            return;
        }

        System.out.println("");
        System.out.println("Path is :");

        int i = dstn;
        System.out.print(dstn + " <-- ");
        while (i != src) {
            System.out.print(path[i] + " <-- ");
            i = path[i];
        }

        System.out.println("");
        System.out.println("");

        System.out.println("Total distance is :" + dist[dstn]);

    }

    public static void main(String[] args) {
        int verticies[] = {0, 1, 2, 3, 4, 5, 6};
        List<int[]> edges = new ArrayList<>();

        int[] ele = {1, 2, 3};
        edges.add(ele);

        ele = new int[]{0, 4};
        edges.add(ele);

        ele = new int[]{0, 3};
        edges.add(ele);

        ele = new int[]{0, 2};
        edges.add(ele);

        ele = new int[]{1, 5};
        edges.add(ele);

        ele = new int[]{4, 6};
        edges.add(ele);

        ele = new int[]{5};
        edges.add(ele);

        BFS.bfs(verticies, edges, 2, 6);
    }
}
