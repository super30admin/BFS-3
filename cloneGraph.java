/*
Problem: https://leetcode.com/problems/clone-graph/
TC: O(V + E)
SC: O(V)
*/


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

// Approach 1: BFS
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node newNode = clone(node);
        
        queue.add(node);
        map.put(node, newNode);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Node n = queue.poll();
                List<Node> neighbors = n.neighbors;
                
                for (Node neighbor : neighbors) {
                    if (!map.containsKey(neighbor)) {
                        map.put(neighbor, clone(neighbor));
                        queue.add(neighbor);
                    }
                    map.get(n).neighbors.add(map.get(neighbor));
                }
            }
        }
        return newNode;
    }
    
    private Node clone(Node node) {
        Node newNode = new Node(node.val);
        newNode.neighbors = new ArrayList<>();
        return newNode;
    }


// Approach 2: DFS
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        
        HashMap<Node, Node> map = new HashMap<>();
        Node newNode = clone(node);
        map.put(node, newNode);
        
        dfs(node, map);
        return newNode;
    }
    
    private void dfs(Node node, HashMap<Node, Node> map) {
        List<Node> neighbors = node.neighbors;
        
        for (Node neighbor : neighbors) {
            if (!map.containsKey(neighbor)) {
                map.put(neighbor, clone(neighbor));
                dfs(neighbor, map);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }
    
    private Node clone(Node node) {
        Node newNode = new Node(node.val);
        newNode.neighbors = new ArrayList<>();
        return newNode;
    }
}