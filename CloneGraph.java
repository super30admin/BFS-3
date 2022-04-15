//  Time Complexity: O(v+e)
//  Space Complexity: O(n)

import java.util.*;

public class CloneGraph {

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

    Map<Node, Node> map;

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        map = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();

        Node deepCopy = new Node(node.val);
        map.put(node, deepCopy);
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            List<Node> neighbors = cur.neighbors;
            for (Node n : neighbors) {
                if (!map.containsKey(n)) {
                    //  create deep copy of neighbor
                    deepCopy = new Node(n.val);
                    map.put(n, deepCopy);
                    queue.offer(n);
                }

                //  process the neighbors for deep copy of current node
                //  get deep copy of current node
                //  in that deep copy node neighbors, put the deep copy of my cur node neighbors
                map.get(cur).neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }
}
