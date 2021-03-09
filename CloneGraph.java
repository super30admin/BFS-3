/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
/*
method 1: using BFS approach 
Maintain a hashmap of original node as key and value as copy node. 
use queue to traverse the graph. 
Add the first node to queue and add it to visited hashmap. Get its neighbors and check if visited or not.
if not, add to hashmap and to the queue. 
TC : O(v+e)
SC :O(v)

method 2: DFS approach
similar to bfs i.e. maintianing of hashmap
TC:O O(v+e)
SC: O(v)
*/

class Solution {
    HashMap<Node,Node> visited;
    public Node cloneGraph(Node node) {
        if(node == null)return node;
        
        this.visited = new HashMap<>();
        
        ///method 1
//         Queue<Node> queue = new LinkedList<>();
//         queue.add(node);
//         Node firstCopy = new Node(node.val);
//         visited.put(node, firstCopy);
        
//         while(!queue.isEmpty()){
//             Node curr = queue.poll();
            
//             if(curr.neighbors != null){
//                 for(Node n : curr.neighbors){
//                     if(!visited.containsKey(n)){
//                      Node copy = new Node (n.val);
//                      visited.put(n,copy);
//                      queue.add(n);
//                    }
            
//                     //get the copied node from hashmap
//             //add the original nodes adjcency list to the copy node also
//             Node clonnedNeighbor = visited.get(n);
//             visited.get(curr).neighbors.add(clonnedNeighbor);
//              }
//             }
           
//         }
        dfs(node);
        return this.visited.get(node);
        
    }
    
    private void dfs(Node node){
        if(this.visited.containsKey(node)){
            return;
        }
        Node copyNode = new Node(node.val);
        this.visited.put(node,copyNode);
        for(Node n : node.neighbors){
            dfs(n);
            this.visited.get(node).neighbors.add(this.visited.get(n));
        }
    }
}