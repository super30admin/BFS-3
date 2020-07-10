// Time Complexity : O(v + e) where v is the number fo vertices and e is the number of edges
// Space Complexity : O(v) where v is the number fo vertices in the Map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  None
/* Your code here along with comments explaining your approach: We store the initial node. From the initial node and its reference to the map, we fetch
the neighbors of the node. As we get the neighbors, depending on the approach, if BFS, we iterate over the neighbors to add it to the neighbor list
of the curretn node to be explored at the next step. If DFS, then we explore the neighbors further and add their neighbors to the map along with its 
reference. If the map already contains the key, it means that the node copy is already present and hence we return back. 
*/
// APPROACH 1 : BFS
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Integer, Node> store = new HashMap<>();                                             // Store node and its reference
        Queue<Node> q = new LinkedList<>();                                                         // Process the neighbors one by one
        q.add(node);
        store.put(node.val, new Node(node.val));
        Node cn = store.get(node.val);                                                              // Head to the first node reference (copy)
        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> nb = curr.neighbors;                                                         // Get neighbors of the current node
            for(Node n : nb){
                if(!store.containsKey(n.val)){
                    store.put(n.val, new Node(n.val));                                              // Put it into the map along with the copy
                    q.add(n);                                                                       // Add it to the queue to be processed later
                }   
                store.get(curr.val).neighbors.add(store.get(n.val));                                //  Add it to the neighbors of the current node
            }   
        }
        return cn;
    }
}

// APPROACH 2: DFS
class Solution {
    HashMap<Integer, Node> store;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        store = new HashMap<>();
        dfs(node);                                                                                  // Start exploring
        return store.get(node.val);                                                                 // return the copy reference of the head node
    }
    private void dfs(Node node){
        if(store.containsKey(node.val)) return;                                                     // if the map contains key, return back
        store.put(node.val, new Node(node.val));                                                    // put the neighboring node to the map
        List<Node> curr = node.neighbors;
        for(Node n : curr)
        {   
            dfs(n);                                                                                 // Start DFS from the neighbros
            store.get(node.val).neighbors.add(store.get(n.val));                                    // Add the neighbors to the corresponding node's neighbor list for whom you are doing DFS
            
        }
    }
}