import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 Using DFS approach
 TC = O(V+E)
 SC = O(V)
 */


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


class CloneGraph {
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        map = new HashMap<>();

        return dfs(node);

    }

    private Node dfs(Node node) {
        //base
        if(map.containsKey(node))
            return map.get(node);

        Node cloneNode = cloneNode(node);

        List<Node> neighbors = node.neighbors;
        for(Node neighbor : neighbors) {
            cloneNode.neighbors.add(dfs(neighbor));
        }

        return cloneNode;
    }

    private Node cloneNode(Node node) {
        if(map.containsKey(node)) {
            return map.get(node);
        }

        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        return cloneNode;
    }
}