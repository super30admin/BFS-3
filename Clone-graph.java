//time O(V+ E)
//space O(V)
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        HashMap<Integer, Node> map = new HashMap<>();
        Node copyNode = new Node(node.val);
        map.put(node.val, copyNode);
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            for(Node neigh : curr.neighbors) {
                if(!map.containsKey(neigh.val)) {
                    Node copy = new Node(neigh.val);
                    map.put(neigh.val, copy);
                    q.add(neigh);
                }
                //put the neighbors copy to the copy node
                map.get(curr.val).neighbors.add(map.get(neigh.val));
            }
        }
        return copyNode;
    }
}