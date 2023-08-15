// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach: The cloneGraph function performs a deep copy of a graph represented by nodes and their neighbors, using BFS and a hash map for tracking. It starts by adding the original node to the queue and initializing a mapping from original nodes to their corresponding copies. It then iterates through the nodes in the queue, cloning them and their neighbors, and connecting them in the copied graph. The clone function ensures that each node is cloned only once and adds it to the hash map. The algorithm has a linear time complexity of O(V + E), where V is the number of nodes and E is the number of edges, and linear space complexity for the map and queue.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    HashMap<Node, Node> map;

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        this.map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node copyNode = clone(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node ne : curr.neighbors) {
                if (!map.containsKey(ne)) {
                    q.add(ne);
                    // clone(ne);
                }
                Node copyNe = clone(ne);
                // How to add Neighbors of deep copy node
                map.get(curr).neighbors.add(copyNe);

            }
        }
        // return map.get(node);
        return copyNode;
    }

    private Node clone(Node node) {
        if (!map.containsKey(node)) {
            Node newNode = new Node(node.val);
            map.put(node, newNode);
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        CloneGraph cloneGraph = new CloneGraph();

        // Create nodes and construct graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone the graph
        Node clonedNode = cloneGraph.cloneGraph(node1);

        // Print the original and cloned graph
        System.out.println("Original Graph:");
        printGraph(node1);

        System.out.println("\nCloned Graph:");
        printGraph(clonedNode);
    }

    private static void printGraph(Node node) {
        HashMap<Node, Integer> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited.put(node, 1);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print("Node " + curr.val + " -> ");
            for (Node ne : curr.neighbors) {
                System.out.print(ne.val + " ");
                if (!visited.containsKey(ne)) {
                    q.add(ne);
                    visited.put(ne, 1);
                }
            }
            System.out.println();
        }
    }
}
