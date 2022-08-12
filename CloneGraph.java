public class CloneGraph {
    // TC is O(V+E)
    // SC is V
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node child: curr.neighbors){
                if(!map.containsKey(child)){
                    Node childCopy = new Node(child.val);
                    map.put(child, childCopy);
                    q.add(child);
                }
                map.get(curr).neighbors.add(map.get(child));
            }
        }
        return copyNode;
    }
}