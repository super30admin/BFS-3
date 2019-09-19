/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}
    public Node(int val) {
    this.val = val;
    }
    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        // 
        if(node == null) return null;
        
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>(); 
        
        /**
         * Map : {
         * 
         *  'VALUE' : 'NODE'
         * 
         * }
         * 
         * Node {
         * 
         *  val ;
         *  [neighbor nodes] -list of neighbor nodes
         * }
         */
        Node newNode = new Node(node.val, new ArrayList<Node>());
        queue.add(node);
        map.put(newNode.val, newNode);
        
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            
            // iterate through each neighbor
            for(Node neighbor : curr.neighbors) {
                // if not visisted add to queue
                if(!map.containsKey(neighbor.val)) {
                    queue.add(neighbor);
                    // create a new node and insert to map 
                    map.put(neighbor.val, new Node(neighbor.val, new ArrayList<Node>()));                   
                }
                
                // update the neighbor list of nodes
                map.get(curr.val).neighbors.add(map.get(neighbor.val));
            } 
            
        }
        
        return newNode;
    }
}