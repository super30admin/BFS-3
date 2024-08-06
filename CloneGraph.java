// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
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

class CloneGraph {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        this.map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node cloneNode = clone(node);
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            List<Node> adjacentNodes = curr.neighbors;
            for(Node neighbor : adjacentNodes) {
                if(!map.containsKey(neighbor)) {
                    queue.add(neighbor);
                }
                Node cloneNeighbor = clone(neighbor);
                map.get(curr).neighbors.add(cloneNeighbor);
            }
        }
        return cloneNode;
    }
    private Node clone(Node node) {
        if(!map.containsKey(node)) {
            map.put(node, new Node(node.val));
        }
        return map.get(node);
    }
}