// Time Complexity : O(V+E) : we are iterating over all the vertices and edges and creating a copy of it
// Space Complexity : O(V) we are only adding the vertices to queue and verices and a deep copy of it to hashmap. No edges are added
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : after class solution


// Your code here along with comments explaining your approach
//We keep track of the original (using queue) and deep copy (using hashmap of original node and it's deep copy) of it. Whenever, we process an original node from queue we check whether it's neighbours are visisted or not.
//If not, then we create a deep copy of them and put it both in hashmap and map.
//We create the edges using the cloned (deep copy of) current node and it's neighbor's deep copy nodes.
//Finally we return the clone node.

class Solution {
    public Node cloneGraph(Node node) {
 
        if(node == null) return null;
        
        //we will use a map to store the deep copy of the nodes visited
        HashMap<Integer, Node> storeCopy = new HashMap<>();
        
        //we will use BFS. So to store the original nodes visited we will use Queue
        Queue<Node> q = new LinkedList<>();
        
        //The first node is visited first. So store it in the queue
        q.offer(node);
        //make a deep copy of it to store it in the map. Since, there are no neighbours of the deep copy yet, so don't add the neighbours right now
        Node cloneNode = new Node(node.val);
        
        //store the original and it's clone node in the map
        storeCopy.put(node.val, cloneNode);
        
        //start processing the queue
        while(!q.isEmpty()){
            //pop the node inside the queue to be processed
           Node current = q.poll(); 
            Node cloneCurrent = storeCopy.get(current.val);
            
            //find it's neighbours
            for(Node neighbor: current.neighbors){
                //for each neighbour check whether it's clone exists or not
                Node cloneNeighbor = storeCopy.get(neighbor.val);
                
                //if doesn't exist then make a clone and add it to the hashmap (store)
                if(cloneNeighbor == null){
                    cloneNeighbor = new Node(neighbor.val);
                    storeCopy.put(cloneNeighbor.val, cloneNeighbor);
                    //add the original to the queue
                    q.offer(neighbor);
                }
                
                //create the edges for the current node
                cloneCurrent.neighbors.add(cloneNeighbor);
            }
            
        }
        //return the clone node
        return cloneNode;
    }
}
