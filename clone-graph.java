// DFS - O(N), O(N)
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
    HashMap<Node, Node> map;       
    
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }
        map = new HashMap<>(); 
        
        dfs(node);
        return map.get(node);
        
    }
    private void dfs(Node node) {
        if(map.containsKey(node)) {
            return;
        }
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        for(Node n : node.neighbors) {
            dfs(n);
            map.get(node).neighbors.add(map.get(n));
        }
    }
}
// BFS
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
