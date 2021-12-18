//Timecomplexity:- O(n);
//spacecomplexity:-O(N).



class Solution {
    private HashMap<Integer,Node> cache=new HashMap<>();
        
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        return dfs(node);    
    }
    private Node dfs(Node node){
        if(cache.containsKey(node.val)){
            return cache.get(node.val); // idea is mapping old nodes with new nodes of same values, implies oldnode
                                       //value as keys and new same node values as values.
                                    // we will perform dfs in which if node already found in hashmap returning that node
                                // else linking by linking to neighbours till leaf reccursivesly.
        }
        Node newnode=new Node(node.val,new ArrayList<>());
        cache.put(node.val,newnode);
        for(Node val:node.neighbors){
            Node child=dfs(val);
            newnode.neighbors.add(child);
            
        }
        return newnode;
        
        
    }
}