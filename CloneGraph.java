// Time complexity - O(n)
// Space complecity - O(n)
// Tested in leetcode

// Allocated a queue to traverse the graph level wise. 
class CloneGraph {
    
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        // map to track the visited node
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val,new ArrayList<>()));
        
        while(!queue.isEmpty()){
            Node root = queue.poll();
           
            for(Node n : root.neighbors){
                 if(!map.containsKey(n)){
                    map.put(n,new Node(n.val, new ArrayList<>()));
                    queue.add(n);
                }
                map.get(root).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}


