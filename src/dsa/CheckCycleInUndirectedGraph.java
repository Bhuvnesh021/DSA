package dsa;

import models.Edge;

import java.util.ArrayList;
import java.util.List;

public class CheckCycleInUndirectedGraph {
    /**
     * 0 -- 1 -- 2 -- 6
     *  \    \
     *   3 -- 4 -- 5 -- 7
     */
    public static void main(String[] args) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            graph.add(new ArrayList<Edge>());
        }
        graph.get(0).add(new Edge(0 ,1));
        graph.get(1).add(new Edge(1 ,0));
        graph.get(1).add(new Edge(1 ,2));
        graph.get(2).add(new Edge(2 ,1));
        graph.get(2).add(new Edge(2 ,6));
        graph.get(6).add(new Edge(6 ,2));
        graph.get(1).add(new Edge(1 ,4));
        graph.get(0).add(new Edge(0 ,3));
        graph.get(3).add(new Edge(3 ,0));
        graph.get(3).add(new Edge(3 ,4));
        graph.get(4).add(new Edge(4 ,3));
        graph.get(4).add(new Edge(4 ,1));
        graph.get(4).add(new Edge(4 ,5));
        graph.get(5).add(new Edge(5 ,4));

        boolean[] vis = new boolean[graph.size()];
        boolean checkForCycle = checkForCycle(graph, 0, vis, -1);

    }

    private static boolean checkForCycle(List<List<Edge>> graph, int current, boolean[] vis, int parent) {
        vis[current] = true;
        for (Edge edge : graph.get(current)) {
            if(!vis[edge.getDestination()]) {
                System.out.print(current + " ");
                checkForCycle(graph, edge.getDestination(), vis, current);
            }
        }

        return false;
    }
}
