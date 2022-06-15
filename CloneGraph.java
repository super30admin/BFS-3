import java.util.*;

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
    // BFS Approach
    // TC : O(V + E)
    // SC : O(V)
    Map<Node, Node> map;
    public Node cloneGraph_BFS(Node node) {
        if(node == null) return null;

        map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        clone(node);
        q.add(node);

        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> neighbors = curr.neighbors;
            for(Node n : neighbors) {
                if(!map.containsKey(n)) { // Kind of a marking a node as visited. Else it will clone the node which is already cloned
                    clone(n);
                    q.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }

        return map.get(node);
    }

    // DFS Approach
    public Node cloneGraph_DFS(Node node) {
        if (node == null) return null;
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node) {
        if(map.containsKey(node)) return;

        cloneDFS(node);

        for(Node n : node.neighbors) {
            dfs(n);
            map.get(node).neighbors.add(map.get(n));
        }
    }

    private Node clone(Node node) {
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        return copyNode;
    }

    private Node cloneDFS(Node node) {
        if(map.containsKey(node)) return node;
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        return copyNode;
    }
}
