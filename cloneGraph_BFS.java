// Time Complexity : O(n) where n is the number of nodes in the graph
// Space Complexity : O(n) where n is the number of nodes in the graph
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

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
class cloneGraph_BFS {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node.val, new Node(node.val, new ArrayList<>()));
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node n : curr.neighbors) {
                if (!map.containsKey(n.val)) {
                    map.put(n.val, new Node(n.val, new ArrayList<>()));
                    q.add(n);
                } 
                map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return map.get(node.val);
    }
}