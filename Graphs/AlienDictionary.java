package graphs;

import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println("Result "+findOrder(words, 4));//Result [b, d, a, c]
    }

    private static List<Character> findOrder(String[] words, int nodes) {
        //Create a Directed Graph from the words
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int node = 0;node<nodes;node++) {
            adjList.put(node, new ArrayList<>());
        }

        for (int i=0;i<words.length - 1;i++) {
            //compare
            for(int start=0;start<Math.min(words[i].length(), words[i+1].length());start++) {
                if(words[i].charAt(start) != words[i+1].charAt(start)) {
                    int node1 = words[i].charAt(start) - 'a';
                    int node2 = words[i+1].charAt(start) - 'a';
                    //Add to adjList
                    adjList.get(node1).add(node2);
                    break;
                }
            }
        }

        System.out.println("Adjacency List "+adjList);//Adjacency List {0=[2], 1=[0, 3], 2=[], 3=[0]}
        //Now apply the topological sort
        List<Character> orderListDFS = usingDFS(adjList, nodes);
        List<Character> orderListBFS = usingBFS(adjList, nodes);
        return orderListBFS; //orderListDFS
    }

    private static List<Character> usingBFS(Map<Integer, List<Integer>> adjList, int nodes) {
        //Topological Sorting using BFS: Khan's Algorithm
        //step1:
        int[] visited = new int[nodes];
        int[] inDegree = new int[nodes];

        //Construct the inDegree for all nodes [2, 0, 1, 1]
        for(int node=0;node<nodes;node++) {
            for(int n: adjList.get(node)) {
                inDegree[n]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Character> orderList = new ArrayList<>();
        //Initially add all the nodes having inDegree zero
        for(int node=0;node<nodes;node++) {
            if(inDegree[node] == 0) {
                queue.add(node);
                orderList.add((char)(node+'a'));
            }
        }

        bfs(queue, adjList, orderList, visited, inDegree);
        return orderList;
    }

    private static List<Character> usingDFS(Map<Integer, List<Integer>> adjList, int nodes) {
        //Topological Sorting using DFS
        //Step1:
        int[] visited = new int[nodes];
        Stack<Integer> stack = new Stack<>();

        for(int node = 0;node<nodes;node++) { //covering all the connected components
            if(visited[node] == 0) {
                dfs(node, adjList, visited, stack);
            }
        }

        //After completing the Graph Traversal
        List<Character> orderList = new ArrayList<>();
        while(!stack.isEmpty()) {
            orderList.add((char)(stack.pop() + 'a'));
        }
        return orderList;
    }

    private static void bfs(Queue<Integer> queue, Map<Integer, List<Integer>> adjList,
                            List<Character> orderList, int[] visited, int[] inDegree) {
        int level = queue.size();
        if(level == 0)
            return;

        while(level > 0) {
            int node = queue.poll();
            visited[node] = 1;

            for(int n: adjList.get(node)) {
                if(visited[n] == 0) {
                    //step1: reducing the inDegree of node "n" or traversing through the node
                    inDegree[n]--;
                    if(inDegree[n] == 0) {
                        queue.add(n);
                        orderList.add((char)(n+'a'));
                    }
                }
            }
            level--;
        }
        bfs(queue, adjList, orderList, visited, inDegree);
    }

    private static void dfs(int node, Map<Integer, List<Integer>> adjList, int[] visited, Stack<Integer> stack) {
        visited[node] = 1;

        for(int n: adjList.get(node)) {
            if(visited[n] == 0) {
                dfs(n, adjList, visited, stack);
            }
        }
        stack.add(node);
    }
}

