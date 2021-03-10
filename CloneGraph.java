class CloneGraph {
  
    /*
        Time : O(V)  | # of vertices
        Space : O(V) | # of vertices stored in map and queue
        Leetcode : YES
    */
  
    /*
      Follow similar approach as for copy list with random pointers
      // BFS
    */
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        
        Queue<Node> que = new LinkedList<>();
        HashMap<Node,Node> map = new HashMap<>();
        Node copyHead = new Node(node.val);
        
        que.add(node);
        map.put(node,copyHead);
        
        while(!que.isEmpty()){
            int size = que.size();
            
            Node curr = que.poll();
            
            for(Node n : curr.neighbors){
                
                if(!map.containsKey(n)){
                    Node cloneN = new Node(n.val);
                    map.put(n, cloneN);                    
                    que.add(n);
                }
                 
                // get the clone of current node         |  map.get(curr)
               // get it's neighbors list                | .neighbors
              // and add currently cloned node into list | map.get(n)
                map.get(curr).neighbors.add(map.get(n));
            }                    
        }
        
        return copyHead;        
    }
  
    /*
      DFS 
      Time : O(V)
      Space : O(V)
      Leetcode : YES
    */
  
    HashMap<Node,Node> map = new HashMap<>();
    void dfs(Node node){
        if(map.containsKey(node)) return;
        
        Node cloned = new Node(node.val);
        map.put(node, cloned);
        
        for(Node n : node.neighbors){
            dfs(n);
            map.get(node).neighbors.add(map.get(n));
        }
    }
    
     public Node cloneGraph(Node node) {
         if(node == null ) return node;
         dfs(node);
         return map.get(node);
     }
}
