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
    
    // BFS
    // Time Complexity: O(V+E)    (where V -> number of vertices and E -> number of edges)
    // Space Complexity: O(V)
    
    public Node cloneGraph(Node node) {
        // Edge Case Checking
        if(node == null)
            return node;
        
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        q.offer(node);
        // Put the root node and create a new node with that value
        map.put(node, new Node(node.val));
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            // Explore the neighbor of the current node
            for(Node neighbor : curr.neighbors){
                // If the map does not contain the neighbor --> create a new entry as well as create a new node of this neighbor in our cloned graph
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }
                
                // For the node in cloned graph (same as curr.val) -> we add to its neighbors list -> the new neighbor node (same as current's -> neighbor)
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        
        // we return the new root node of the cloned graph
        return map.get(node);
    }
}