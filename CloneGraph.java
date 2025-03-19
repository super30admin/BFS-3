
class Solution {
    //Time Complexity:O(V+C)
    //Space Complexity:O(V)
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (node.neighbors.isEmpty()) return new Node(node.val);
       HashMap<Node, Node> map = new HashMap<>();
       Queue<Node> q = new LinkedList<>();
       q.offer (node);
       map.put (node, new Node(node.val));
       while (!q.isEmpty()){
        Node curNode = q.poll();
        for (Node n : curNode.neighbors){
            if (!map.containsKey(n)){
                map.put(n , new Node (n.val));
                q.offer(n);
            }
            map.get(curNode).neighbors.add(map.get(n));
        }
       }
       return map.get(node);
   }
}
