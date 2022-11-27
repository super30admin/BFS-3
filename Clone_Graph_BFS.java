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

// TC : O(V + E)
// SC : (V)
// METHOD - BFS
class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<>()));
        while(!q.isEmpty()) {
            Node curr = q.poll();
                for(Node temp : curr.neighbors) {
                    if(!map.containsKey(temp)) {
                        clone(curr, temp);
                        q.add(temp);
                    }
                    map.get(curr).neighbors.add(map.get(temp));
                }
        }
        return map.get(node);
    }
    
    private void clone(Node curr, Node node) {
            Node temp = new Node(node.val, new ArrayList<>());
            map.put(node, temp);
    }
}
