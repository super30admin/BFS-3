// Time Complexity : O(V*E)
// Space Complexity :O(V)
class Solution {
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        map=new HashMap<>();
        clone(node);
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(node.neighbors!=null){
                for(Node n:curr.neighbors){
                    if(!map.containsKey(n)){
                        clone(n);
                        q.add(n);
                    }
                    map.get(curr).neighbors.add(map.get(n));
                }
            }
        }
       
        return map.get(node);
    }
    
    private void clone(Node node){
        if(map.containsKey(node)) return;
        Node newnode=new Node(node.val);
        map.put(node,newnode);
    }
}