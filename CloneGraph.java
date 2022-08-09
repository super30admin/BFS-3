//Time: O(V+E)
//Space: O(V)
public class CloneGraph {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node n: curr.neighbors){
                if(!map.containsKey(n)){
                    Node copyN = new Node(n.val);
                    map.put(n, copyN);
                    q.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}
