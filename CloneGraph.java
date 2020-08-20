//Time - O(V+E) - V vertices , E edges
//Space - O(n)
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node.val,new Node(node.val));
        
        while(!q.isEmpty()){
            Node n = q.poll();
            List<Node> neighbors = n.neighbors;
            for(int i=0;i<neighbors.size();i++){
                Node nextNode = neighbors.get(i);
                if(!map.containsKey(nextNode.val)){
                    map.put(nextNode.val,new Node(nextNode.val));
                    q.add(neighbors.get(i));
                }
                map.get(n.val).neighbors.add(map.get(nextNode.val));
            }
        }
        return map.get(node.val);
        
    }
}
