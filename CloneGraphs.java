import java.util.*;

public class CloneGraphs {



    //In order to main the deep copy use hashmap with original with copy.
    //Before creating any copy check if it exists or not.
    //if doesn't create a new one and add it to the map.

    //First create a new node copy of first node
    //Iterate all the neighbors and check whether exists in map or not.
    //Update the current node's neighbors which we created/got from map.
    //TC:O(V+E) - Visiting all notes and edges
    //SC:O(V) - In the queue it will be maximum V elements
    public Node cloneGraph(Node node) {
        
        if(node == null) return null;
        
        HashMap<Node, Node> map = new HashMap();
        
        Queue<Node> queue = new LinkedList();
        Node nodeCopy = new Node(node.val);
        map.put(node,nodeCopy);
        queue.add(node);
        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            //Iterate all the neighbors and create nodes and add it to the queue and map.
            for(Node neighbor: currentNode.neighbors) {
                if(!map.containsKey(neighbor)) {
                    Node neighborCopy = new Node(neighbor.val);
                    map.put(neighbor, neighborCopy);
                    queue.add(neighbor);
                }
                //Add neighbor of current copy node
                map.get(currentNode).neighbors.add(map.get(neighbor));
            }
        }
        return nodeCopy;
    }

    public static void main(String[] args) {
        // CloneGraphs cloneGraphs = new CloneGraphs();
        // cloneGraphs.cloneGraph();
    }
}