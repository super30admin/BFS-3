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
// Time Complexity : O(V + E) // number of nodes and edges
// Space Complexity : //O(V) // number of nodes for hashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a queue of nodes and hashmap of Integer to Node where we will store the node value and clone node
// We will take the given node and create a clone of this and add it to queue and add its clone to hashmap
// Now we will run while loop till the queue is not empty
// We will poll current node, iterate its neighbors and check in the map if the its clone exist or not
// If not we will create clone also add the original node in the queue
// We will get the current clone node from hashmap and add the neigbor clone to its neighbor
// Finally we will return the clone of the given node value using hashmap
class Solution {
    public Node cloneGraph(Node node) {
        
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer, Node> hm = new HashMap<>();
        if(node == null)
            return null;
        Node cloneNode = new Node(node.val);
        q.add(node);
        hm.put(cloneNode.val, cloneNode);     
        while(!q.isEmpty()){
            Node cur = q.poll();
           for(Node node1: cur.neighbors){
               if(!hm.containsKey(node1.val)){
                   Node clone = new Node(node1.val);
                    hm.put(clone.val, clone); 
                    q.add(node1);
                }
               hm.get(cur.val).neighbors.add(hm.get(node1.val));
           }
        }
        return hm.get(node.val);
    }
}