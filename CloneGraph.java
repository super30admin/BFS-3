
// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class CloneGraph {
    HashMap<Node, Node> map;

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        this.map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node cloneNode = clone(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            List<Node> neighbors = curr.neighbors;
            for (Node neighbor : neighbors) {
                if (!map.containsKey(neighbor)) {
                    q.add(neighbor);
                }
                Node cloneNeighbor = clone(neighbor);
                map.get(curr).neighbors.add(cloneNeighbor);
            }
        }

        return cloneNode;
    }

    private Node clone(Node node) {
        if (!map.containsKey(node)) {
            map.put(node, new Node(node.val));
        }
        return map.get(node);
    }

   
    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();

       
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);
        node3.neighbors.add(node2);

        
        Node clonedGraph = solution.cloneGraph(node1);

        
        System.out.println("Original Graph:");
        solution.printGraph(node1);
        System.out.println("\nCloned Graph:");
        solution.printGraph(clonedGraph);
    }

   
    private void printGraph(Node node) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print("Node " + curr.val + " Neighbors: ");
            for (Node neighbor : curr.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor)) {
                    q.add(neighbor);
                    visited.add(neighbor);
                }
            }
            System.out.println();
        }
    }
}
