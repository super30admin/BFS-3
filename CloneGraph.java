// Time Complexity : O(V+E),
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class CloneGraph {
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


    class Solution {
        private Node cloneNode;
        private Map<Node, Node> visited;
        public Node cloneGraph(Node node) {
            visited = new HashMap<>();
            return dfs(node);
        }

        private Node dfs(Node node) {
            //base
            if(node  == null) return node;

            if (visited.containsKey(node)) {
                return visited.get(node);
            }
            //logic
            Node cloneNode = new Node(node.val, new ArrayList<Node>());
            visited.put(node, cloneNode);
            for(Node neighbour : node.neighbors) {
                cloneNode.neighbors.add(dfs(neighbour));
            }
            return cloneNode;
        }
    }
}
