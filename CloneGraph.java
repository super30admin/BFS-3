import java.util.*;
// Time Complexity :(n+m)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : getting started

// Your code here along with comments explaining your approach
public class CloneGraph {
    /*
// Definition for a Node.*/
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

    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) return node;//base case

            //hashmap to store visited nodes
            HashMap<Node, Node> visited = new HashMap();

            // add first node to queue
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(node);

            // Clone the node and add to visited
            visited.put(node, new Node(node.val, new ArrayList()));

            // Begin bfs
            while (!queue.isEmpty()) {
                // Pop node from front of queue and iterate through all neighbours
                Node n = queue.remove();
                for (Node neighbor: n.neighbors) {
                    if (!visited.containsKey(neighbor)) {
                        //add to hashmap if not present and to queue
                        visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                        queue.add(neighbor);
                    }
                    //add node to neighbors
                    visited.get(n).neighbors.add(visited.get(neighbor));
                }
            }
            return visited.get(node);//return cloned nodes
        }
    }

}
