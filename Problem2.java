package BFS-3;
// TC: O(V+E)
// SC: O(V)
public class Problem2 {
    public Node cloneGraph(Node node) {
        if(node==null) return node;

        HashMap<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        visited.put(node, new Node(node.val, new ArrayList()));

        while(!q.isEmpty()){
            Node currNode = q.poll();
            for(Node neighbor: currNode.neighbors){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    q.add(neighbor);
                }
                visited.get(currNode).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}
