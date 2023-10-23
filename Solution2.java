// Time Complexity: O(V+E)
// Space Complexity: O(V)



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

class Solution2 {
    public Node cloneGraph(Node node) {
        if( node == null ) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while( !q.isEmpty() ) {
            Node temp = q.poll();
            if( !map.containsKey(temp) ) {
                Node n = new Node(temp.val);
                map.put(temp, n);
            }
            for( Node ne: temp.neighbors ) {
                if( !map.containsKey(ne) ) {
                    Node deep = new Node(ne.val);
                    map.put(ne, deep);
                    q.add(ne);
                }
                map.get(temp).neighbors.add(map.get(ne));
            }
        }
        return map.get(node);
    }
}