//Approach - 1: BFS
//Time Complexity : O(V+E) ; vertices and edges
//Space Complexity : O(V); vertices

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        
        map = new HashMap<>();
        
        if(node == null) return null;
        
        //Deep copy of node val
        Node tempNode = new Node(node.val);
        map.put(node, tempNode);
        
        //add the Original node to Queue
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            
            for(Node child: curr.neighbors){
                Node childTemp = new Node(child.val);
                
                if(!map.containsKey(child)){
                    //add the curr neighbors and its temp node to map
                    map.put(child, childTemp);
                    //add curr neighbor to queue
                    q.add(child);
                }
                
                //Original nodes deep copy, get its neighbors, and add deep copy of child
                map.get(curr).neighbors.add(map.get(child));
                
            }
        }
        //return map.get(node);
        return tempNode;
    }
}




//Approach - 2: DFS
//Time Complexity : O(V+E) ; vertices and edges
//Space Complexity : O(V); vertices

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if(node == null) return null;
        dfs(node);
        return map.get(node);
    }
    private void dfs(Node node){
        //base
        if(map.containsKey(node)) return;
        //logic
        
        //add
        Node tempNode = new Node(node.val);
        map.put(node, tempNode);
        
        for(Node child: node.neighbors){
            dfs(child);
            map.get(node).neighbors.add(map.get(child));
        }
    }
}
