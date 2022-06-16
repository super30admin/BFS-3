//BFS Approach
class Solution {

    // Time Complexity : 0(V+E) where v is the vertices or the nodes and e are the edges
// Space Complexity : 0(V)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


    HashMap<Node, Node> map;    //Storing the orininal node and its deep copy(address of both)
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        map = new HashMap<>();
        Node copyNode = clone(node);    //creating the copy of 1st node
        Queue<Node> q = new LinkedList<>(); //queue for bfs
        q.add(node);    //adding the 1st node for processing and traversing further
        while(!q.isEmpty()){
            Node curr = q.poll();   //removing the node
            List<Node> l = curr.neighbors;  //getting the neighbors of original copy and storing it in list
            for(Node neighbor : l){ //traversing through the neighbor of original node
                if(!map.containsKey(neighbor)){ //if map contains the original node means I have already created a deep copy, if not
                    clone(neighbor);    //creating a deep copy of the neighbor
                    q.add(neighbor);    //adding that to the queue to process it's neighbors
                }
                map.get(curr).neighbors.add(map.get(neighbor)); //adding the neighbors of deep copy to to deep copy neighbors
            }
        }
        return copyNode;    //returning the address of 1st deep copy node

    }
    public Node clone(Node node){   //method to create deep copy
        Node newNode = new Node(node.val);  //creating deep copy
        map.put(node, newNode); //putting it in the hashmap
        return newNode; //returning deep copy
    }
}

//DFS Approach

class Solution {
    HashMap<Node, Node> map;    //to store the address of original and deep copy of the origina;
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        map = new HashMap<>();
        dfs(node);  //calling our recursive function sending the 1st node
        return map.get(node);   //returning the 1st deep copy node's address
    }
    public void dfs(Node node){
        //base condition
        if(map.containsKey(node)){  //if a deep copy is already created, then return
            return;
        }
        //logic
        clone(node);    //creting a deep copy(clone is written only here because if we write inside the for loop. then it will go wring, refer to the video)
        List<Node> l = node.neighbors;  //getting the neighbors of original
        for(Node neighbor : l){ //traversing through the neighbors
            dfs(neighbor);  //calling our recursive function
            map.get(node).neighbors.add(map.get(neighbor)); ////adding the neighbors of deep copy to to deep copy neighbors
        }
    }
    public Node clone(Node node){   //to createe deep copy
        if(map.containsKey(node)){  //adding an extra condition as if the deep copy is already created, then just returning that
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}