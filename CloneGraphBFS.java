class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node, new Node(node.val));
        while(!q.isEmpty()) {
            Node curr = q.poll();
            for(Node n : curr.neighbors) {
                if(!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    q.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }

    private Node clone(Node node) {
        if(node == null) {
            return null;
        }
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node();
        map.put(node, newNode);
        return newNode;
    }
}