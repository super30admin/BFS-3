/*
// Definition for a Node.
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
*/
import java.util .*;
// Time complexity : O(V+E)
// Space complexity: O(V)

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node copyNode = clone(node);
        q.add(node);

        while(!q.isEmpty()) {
            Node curr = q.poll();
            for (Node n : curr.neighbors) {
                if(!map.containsKey(n)) {
                    q.add(n);
                    clone(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }

        return copyNode;

    }

    private Node clone (Node node) {
        Node newNode = new Node(node.val);
        if(!map.containsKey(node)) {
            map.put(node, newNode);
        }
        return newNode;
    }
}
