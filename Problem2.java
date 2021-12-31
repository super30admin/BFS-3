// 133 Clone graph
// time - O(v + e)
// space - O(v)
class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap();
        
        Queue<Node> q = new LinkedList();
        Node copy = new Node(node.val);
        map.put(node, copy);
        q.add(node);
        
        while(!q.isEmpty()){
            
            Node currNode = q.poll();
            
            for(Node neigh: currNode.neighbors){
                
                if(!map.containsKey(neigh)){
                    
                    Node newNode = new Node(neigh.val);
                    map.put(neigh, newNode);
                    q.add(neigh);
                }
                
                map.get(currNode).neighbors.add(map.get(neigh));
                
            }
        }
        
        return copy;
    }
}