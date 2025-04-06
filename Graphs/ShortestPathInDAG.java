package graphs;

import java.util.*;

public class ShortestPathInDAGFromNodeAtoB {
  
    public static void main(String[] args) {
        int nodes = 6;
        int[][] edgesWithWts = { {0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1} };
        int source = 0;//0, 1, 4

        //prepare the Adjacency List
        Map<Integer, List<Pair>> adjList = new HashMap<>();

        for(int node=0;node<nodes;node++)
            adjList.put(node, new ArrayList<>());

        for(int[] edge: edgesWithWts) {
            adjList.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        //Do the Topological Sort
        Stack<Integer> topoSort = topoSort(adjList, nodes);

        //Create a distance array and do the edge relaxation

        int[] distanceArr = new int[nodes];
        Arrays.fill(distanceArr, Integer.MAX_VALUE);
        distanceArr[source] = 0;
        while(!topoSort.isEmpty()) {
            int node = topoSort.pop();
            int distance = distanceArr[node];
            for(Pair pair: adjList.get(node)) {
                if(distance != Integer.MAX_VALUE){
                    distanceArr[pair.node] = Math.min(distance + pair.weight, distanceArr[pair.node]);
                }
            }
        }

        System.out.println(Arrays.toString(distanceArr)); //[0, 2, 3, 6, 1, 5]
    }

    private static Stack<Integer> topoSort(Map<Integer, List<Pair>> adjList, int nodes) {
        //Using DFS
        int[] visited = new int[nodes];
        Stack<Integer> stack = new Stack<>();

        for(int node=0;node<nodes;node++) {
            if(visited[node] == 0) {
                dfs(node, adjList, visited, stack);
            }
        }
        return stack;
    }

    private static void dfs(int node, Map<Integer, List<Pair>> adjList, int[] visited, Stack<Integer> stack) {
        visited[node] = 1;

        for(Pair pair: adjList.get(node)) {
            if(visited[pair.node] == 0) {
                dfs(pair.node, adjList, visited, stack);
            }
        }
        stack.add(node);
    }

    private static class Pair {
        int node;
        int weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
