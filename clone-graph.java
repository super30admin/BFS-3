//Time,Space-O(N),O(N)
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

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }
        
        Queue<Node> q = new LinkedList<>();
        
        HashMap<Node, Node> map = new HashMap<>();        
        Node copy = new Node(node.val);
        q.add(node);
        map.put(node, copy);
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            for (Node n :cur.neighbors) {
                if(!map.containsKey(n)) {
                    Node copyNode = new Node(n.val);
                    q.add(n);
                    map.put(n, copyNode);
                }
                map.get(cur).neighbors.add(map.get(n));                
            }
        }
        
        return copy;
        
        
        
    }
}
