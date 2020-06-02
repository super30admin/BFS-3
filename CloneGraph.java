// 133.
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

class Solution {
    
    HashMap<Node, Node> clones = new HashMap<>();
        
    public Node cloneGraph(Node node) {
        //edge
        if(node == null)
        {
            return node;
        }
        //return cloneBFS(node);
        cloneDFS(node);
        return clones.get(node);
    }
    
    //time - O(V + E)
    //space - O(V)
    private Node cloneBFS(Node node) {
        HashMap<Node, Node> clones = new HashMap<>(); //each node in original graph maps to its respective clone
        Queue<Node> support = new LinkedList<>(); //for bfs
        support.add(node); //initially add source node to queue
        clones.put(node, new Node(node.val, new ArrayList<Node>())); //create a clone of source
        
        while(!support.isEmpty())
        {
            Node current = support.poll(); //queue front
            //for each neighbor of current node
            List<Node> neighbors = current.neighbors;
            for(Node neighbor : neighbors)
            {
                if(!clones.containsKey(neighbor))
                {
                    //neighbor not processed so far
                    clones.put(neighbor, new Node(neighbor.val, new ArrayList<Node>())); //create a clone
                    support.offer(neighbor); //add to queue to process it in next level
                }
                //to the neighbor list of current's clone, add clone of neighbor
                clones.get(current).neighbors.add(clones.get(neighbor));
            }
        }
        
        return clones.get(node);
    }
    
    //time - O(V + E)
    //space - O(V)
    private void cloneDFS(Node node) {
        //base
        if(clones.containsKey(node))
        {
            return;
        }
        //logic
        clones.put(node, new Node(node.val, new ArrayList<Node>())); //create clone, add to map
        List<Node> neighbors = node.neighbors;
        //for each neighbor - recurse
        for(Node neighbor : neighbors)
        {
            cloneDFS(neighbor);
            //add to adjacency list
            clones.get(node).neighbors.add(clones.get(neighbor));
        }
        return;
    }
}
