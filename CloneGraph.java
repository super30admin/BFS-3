// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class CloneGraph {
    HashMap<Node, Node> visited = new HashMap<Node,Node>();
    public Node cloneGraph(Node node) {
        /*
        1. for each node in neighbors,
           1.1 Create a new node 
           1.2 Add this node to visited
           1.3 Fetch neighbors at this (index - 1)
           1.4 If node isn't created, create node, Add the corresponding neighbors list as node's neighbors
        */
        
        if(node==null)
            return node;
        return dfs(node);

    }
    public Node dfs(Node node){
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        Node newNode = new Node(node.val);
        visited.put(node,newNode);
        for(Node nei: node.neighbors){
            newNode.neighbors.add(dfs(nei));
        }
        return newNode;
    }
}