TC: O(n);
SC: O(n);

Runtime: 27 ms, faster than 56.17% of Java online submissions for Clone Graph.
Memory Usage: 38.7 MB, less than 5.88% of Java online submissions for Clone Graph.

Approach: Using dfs we will traverse all the neighbors of the current node. We will keep track of the visiting nodes using a hashmap.
If a node is visited we will return the node and add it to its parents adjacency list.If we have not visited , we will create a new node with and initialize with empty list and
visit its neighbors further.

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/


class Solution {
    HashMap<Integer, Node> hashmap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)  return node;
                
        return dfs(node);
        
    }
    private Node dfs(Node node){
        // base case
        if(hashmap.containsKey(node.val)){
            return hashmap.get(node.val);  // returning the location of the the nod
        }
        
        Node newnode = new Node(node.val,new ArrayList<>());   
        hashmap.put(node.val,newnode);
        
        for(Node n : node.neighbors){
            newnode.neighbors.add(dfs(n));
        }
        return newnode;
    }
    
}
