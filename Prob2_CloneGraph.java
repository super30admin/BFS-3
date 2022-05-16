//TC : O(|V| + |E| ) --- Traversing total V nodes and their of neighbours
//SC : O(|V|) -- Using Map which is having size total no. of nodes
//DFS solution
class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();    
        if(node == null)    return null;
        
        dfs(node);
        return map.get(node);
    }
    public void dfs(Node node){
        //BASE CASE
        if(map.containsKey(node))   return;
        
        //MAIN LOGIC
        
        //create copy of node on which DFS is called
        
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node demo : node.neighbors){
            
            dfs(demo);
            
            map.get(node).neighbors.add(map.get(demo));
        }
        
    }
}




/*
//TC : O(|V| + |E| ) --- Traversing total V nodes and their of neighbours
//SC : O(|V|) -- Using Map which is having size total no. of nodes

//BFS Solution
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)    return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue= new LinkedList<>();
        
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        
        queue.add(node);
        
        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            List<Node> neighbour = currNode.neighbors;
            for(Node temp : neighbour){
                if(!map.containsKey(temp)){
                    Node newCurr = new Node(temp.val);
                    map.put(temp, newCurr);
                    queue.add(temp);
                }
                
                map.get(currNode).neighbors.add(map.get(temp));
            }
            
            
        }
        
        
        return newNode;
    }
}



*/