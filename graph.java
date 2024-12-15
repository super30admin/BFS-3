
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node res = new Node(node.val);
        map.put(node,res);
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            Node copy=map.get(curr);
            
            for(Node child:curr.neighbors){
                if(!map.containsKey(child)){
                    Node chcopy = new Node(child.val);
                    map.put(child,chcopy);
                    q.add(child);
                }
                copy.neighbors.add(map.get(child));
            }
        }
        return res;
    }
}
