class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        while(!q.isEmpty()){
            Node currNode = q.poll();
            Node copy;
            if(!map.containsKey(currNode)){
                copy = new Node(currNode.val, new ArrayList<>());
                map.put(currNode, copy);
            }
            copy = map.get(currNode);
            for(Node neighbor : currNode.neighbors){
                if(!map.containsKey(neighbor)){
                    Node newCopy = new Node(neighbor.val, new ArrayList<>());
                    map.put(neighbor, newCopy);
                    q.add(neighbor);
                }
                copy.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
