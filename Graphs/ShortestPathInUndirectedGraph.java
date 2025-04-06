package graphs;

import java.util.*;
import java.util.stream.Collectors;

public class ShortestPathInUndirectedGraph {

    public static void main(String[] args) {
        int[][] edges = { {1,3}, {0,2,3}, {1,6}, {0,1,4}, {3,5}, {4,6}, {2,5,7}, {6,8}, {6,7} };
        int sourceNode = 0;//1,

        //Prepare the Adjacency List
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int node = 0;node<edges.length;node++) {
            adjList.put(node, Arrays.stream(edges[node]).boxed().collect(Collectors.toUnmodifiableList()) );
        }

        //Solving this using simple BFS
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sourceNode, 0));

        int[] distanceArr = new int[edges.length];
        Arrays.fill(distanceArr, Integer.MAX_VALUE);
        distanceArr[sourceNode] = 0;
        bfs(queue, adjList, distanceArr);
        System.out.println(Arrays.toString(distanceArr)); //[0, 1, 2, 1, 2, 3, 3, 4, 5]
    }

    private static void bfs(Queue<Pair> queue, Map<Integer, List<Integer>> adjList, int[] distanceArr) {
        if(queue.isEmpty())
            return;

        int level = queue.size();
        while(level > 0){
            Pair pair = queue.poll();
            int node = pair.node;

            for(int n: adjList.get(node)) {
                if(distanceArr[n] == Integer.MAX_VALUE) {
                    distanceArr[n] = pair.distance + 1;
                    queue.add(new Pair(n, distanceArr[n]));
                } else {
                    distanceArr[n] = Math.min(distanceArr[n], pair.distance + 1);
                }
            }
            level--;
        }
        bfs(queue, adjList, distanceArr);
    }

    private static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
