import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class CloneGraphBFS {

        // BFS - Time  O(V+E) and Space O(V)

        public Node cloneGraph(Node node) {

            // null case
            if(node == null) {

                return null;
            }

            // map of nodes to their deep copies
            HashMap<Node, Node> map = new HashMap<>();     // O(V) space

            Node newFirst = new Node(node.val);
            map.put(node, newFirst);

            // queue of original nodes
            Queue<Node> originalQ = new LinkedList<>();

            originalQ.add(node);

            // bfs
            while(!originalQ.isEmpty()) {

                Node curr = originalQ.poll();

                // check neighbors of current node that is polled out of queue
                for(Node neighbor: curr.neighbors) {

                    // if neighbor is not in hash map already, add it to queue and map
                    if(!map.containsKey(neighbor)) {

                        Node newNeighbor = new Node(neighbor.val);

                        map.put(neighbor, newNeighbor);
                        originalQ.add(neighbor);
                    }

                    // add deep copy of neighbor to neighbors list of deep copy of current node
                    map.get(curr).neighbors.add(map.get(neighbor));
                }
            }
            // output first node of clone
            return newFirst;
        }


}

/*
TIME COMPLEXITY = O(V+E)

V - number of vertices (nodes)

E - number of edges in graph

SPACE COMPLEXITY = O(V)

Hash map of nodes has O(V) space
*/