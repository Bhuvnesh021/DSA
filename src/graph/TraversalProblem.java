package graph;

import java.util.*;

public class TraversalProblem {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1,2));
        graph.put(1, Arrays.asList(0,3,4));
        graph.put(2, Arrays.asList(0,4));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1,2));
        Set<Integer> visited = new HashSet<>();
//        bfs(0, visited, graph);
//        visited.clear();
        dfs(0, visited, graph);
    }

    private static void dfs(int i, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        if(!visited.add(i)) {
            return;
        }
        System.out.println(i);
        for (Integer integer : graph.get(i)) {
            dfs(integer, visited, graph);
        }

    }

    private static void bfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            System.out.println(currentNode);
            for (Integer i : graph.get(currentNode)) {
                if(!visited.contains(i)){
                    queue.add(i);
                    visited.add(i);
                }
            }


        }
    }
}
