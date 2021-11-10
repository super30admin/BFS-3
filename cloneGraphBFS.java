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
// Idea here to keep track of cloned nodes using map and from each node keep traversing its neighbors
// and use queue to traverse all nodes
// Time Complexity: O(V+E)
class Solution {
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if(node==null) return node;
        Queue<Node> q = new LinkedList<>();
        Node copyNode = clone(node);
        q.add(node);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            List<Node> nb = curr.neighbors;
            for(Node child: nb){
                if(!map.containsKey(child)){
                    clone(child);
                    q.add(child);
                }
                map.get(curr).neighbors.add(map.get(child));
            }
        }
        return copyNode;
    }
    
    
    private Node clone(Node node) {
        Node copy = new Node(node.val);
        map.put(node, copy);
        return copy;
    }
}