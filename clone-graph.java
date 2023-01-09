
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
import java.util.*;

class Solution {
    HashMap<Node, Node> map;

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        map = new HashMap<>();
        clone(node);
        dfs(node);

        return map.get(node);

    }

    private void clone(Node node) {
        if (map.containsKey(node))
            return;

        Node newNode = new Node(node.val);
        map.put(node, newNode);

    }

    private void dfs(Node node) {
        // base

        // logic

        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                clone(neighbor);
                map.get(node).neighbors.add(map.get(neighbor));
                dfs(neighbor);

            } else {

                map.get(node).neighbors.add(map.get(neighbor));
            }

        }
    }
}
