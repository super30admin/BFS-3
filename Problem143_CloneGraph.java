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

//Time Complexity: O(n) -> O(vertex*edges)

class Solution {
    public Node cloneGraph(Node node) {
        //base case
        if(node == null)
            return null;
        //queue for bfs
        Queue<Node> q = new LinkedList<>();
        //hashmap to store relation between node and its neighbors with deep copy
        //so original node, deepCopy of node and deepCopy of original neighbors
        HashMap<Integer, Node> map = new HashMap<>();
        //initially add the first original node into the queue
        //and add original neighbors
        q.add(node);
        //after the original node is added, create deepCopyNode to store in hashmap
        //having empty arrayList of neighbors
        Node deepCopyNode = new Node(node.val, new ArrayList<>());
        map.put(node.val, deepCopyNode);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node originalNeighbors : curr.neighbors){
                if(!map.containsKey(originalNeighbors.val)){
                    q.add(originalNeighbors); //neigh -> neighbor of original node
                    Node neighborsDeepCopy = new Node(originalNeighbors.val, new ArrayList<>());
                    map.put(originalNeighbors.val, neighborsDeepCopy); 
                }
                //deepcopy of original node and neighbors of it
                //and add deepCopy of neighbors
                map.get(curr.val).neighbors.add(map.get(originalNeighbors.val));
            } 
        }
        //return location of deepCopyNode to get the entire deepCopyGraph
        return deepCopyNode;
    }
}