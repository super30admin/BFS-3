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
// Time Complexity: O(V+E)
// Space Complexity: O(V)

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Integer, Node> store = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node cloneNode = new Node(node.val);
        store.put(node.val, cloneNode);

        queue.offer(node);

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            Node cloneCurrent = store.get(current.val);

            for(Node neighbor: current.neighbors) {
                Node cloneNeighbor = store.get(neighbor.val);
                if(cloneNeighbor == null) {
                    cloneNeighbor = new Node(neighbor.val);
                    store.put(neighbor.val, cloneNeighbor);

                    queue.add(neighbor);
                }
                cloneCurrent.neighbors.add(cloneNeighbor);
            } 
        }

        return cloneNode;
        
    }
}