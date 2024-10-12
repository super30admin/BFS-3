class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Node, Node> hm = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(node);
        Node head = new Node(node.val, new ArrayList<>());
        hm.put(node, head);  
        while (!q.isEmpty()) {
            Node crr = q.poll();
            Node clonedNode = hm.get(crr); 
            for (Node neighbor : crr.neighbors) {
                if (!hm.containsKey(neighbor)) {
                    Node clonedNeighbor = new Node(neighbor.val, new ArrayList<>());
                    hm.put(neighbor, clonedNeighbor);
                    q.add(neighbor);
                }
                clonedNode.neighbors.add(hm.get(neighbor));
            }
        }

        return head;
    }
}