//Time-O(V+E)
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
        if(node==null)
        {
            return node;
        }
        return dfs(node);        
    }
    private HashMap<Integer,Node>map=new HashMap();
    private Node dfs(Node node)
    {
        if(map.containsKey(node.val))
        {
            return map.get(node.val);
        }
        Node newnode=new Node(node.val,new ArrayList());
        map.put(node.val,newnode);
        for(Node n:node.neighbors)
        {
            Node dfsnode=dfs(n);
            map.get(node.val).neighbors.add(dfsnode);
        }
        return newnode;
    }
}