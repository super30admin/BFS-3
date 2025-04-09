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
    public Node cloneGraph(Node node) {
        if(node == null)
        return null;
        HashMap<Node,Node> map = new HashMap<>();
        dfs(node,map);
        
        return map.get(node);
    }
    private void dfs(Node node, HashMap<Node,Node> map)
    {
        //base
        if(map.containsKey(node))
        return;

        //logic
        Node newNode = new Node(node.val);
        map.put(node,newNode);
        for(Node ne: node.neighbors)
        {
            dfs(ne,map);
            
            map.get(node).neighbors.add(map.get(ne));
        }
    }
}

/*
Time Complexity: O(V + E) where V is the number of nodes and E is the number of edges in the graph.

Space Complexity: O(V) where V is the number of nodes in the graph.
 */