package tree;

import java.util.*;

public class RouteBetweenNodes {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);

        graph.addEdge(1, 3);
        System.out.println("ROUTE FROM 1:2 " + graph.hasRoute(1, 2));
        System.out.println("ROUTE FROM 1:3 " + graph.hasRoute(1, 3));

    }

    static class Graph {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        public void addNode(int nodeNum) {
            if (!map.containsKey(nodeNum)) {
                map.put(nodeNum, new HashSet<>());
            }
        }

        public void addEdge(int nodeA, int nodeB) {
            if (map.containsKey(nodeA)) {
                map.get(nodeA).add(nodeB);
            }
        }

        public boolean hasRoute(int nodeA, int nodeB) {
            if (map.containsKey(nodeA) && map.get(nodeA).contains(nodeB)) {
                return true;
            }

            return false;
        }
    }

    static class Node {
        public int data;
        public List<Node> neighbors;
    }
}
