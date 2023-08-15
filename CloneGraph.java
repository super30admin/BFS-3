// BFS 
class Solution {
    public Node cloneGraph(Node node) {
        
        if (node == null) return node;
        
        HashMap<Node, Node> map = new HashMap();
        Queue<Node> q= new LinkedList<>();
        q.add(node);
        
        Node newNode= new Node(node.val);
        map.put(node, newNode);
        // List<Node> list = new ArrayList<>();
        
        while(!q.isEmpty()){
            int size= q.size();
            Node curr= q.poll();
            List<Node> nebor= curr.neighbors;
            for(Node n: nebor){
                if(!map.containsKey(n)){
                    Node deepcp=  new Node(n.val);
                    map.put(n, deepcp);
                    q.add(n);
                }
                
                //get deepcopy of current node
                //get neighbors
                //add deepcopy of neighbors to list
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return newNode;
    }
}
