/**
Time Complexity - O(V + E)
Space Complexity - O(V)
 */
class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null || node.neighbors == null)
            return node;
        
        HashMap<Node, Node> cloneMap = new HashMap<Node, Node>();
        Queue<Node> queue = new LinkedList<Node>();
        cloneMap.put(node, new Node(node.val));
        queue.add(node);

        while(!queue.isEmpty()) {
            Node cur = queue.poll();        
            for(Node t : cur.neighbors) {
                if(!cloneMap.containsKey(t)) {
                    cloneMap.put(t, new Node(t.val));
                    queue.add(t);
                }
                cloneMap.get(cur).neighbors.add(cloneMap.get(t));
            }
        }

        return cloneMap.get(node);
    }
}
