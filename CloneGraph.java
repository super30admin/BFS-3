import java.util.ArrayList;
import java.util.HashMap;
/*
Time Complexity: O(N+E), where N is the number of Nodes in the Graph and E is the edges to the neighbors
Space Compelxity: O(N) space require to maintain HashMap
Run on leetcode: yes
Any difficulties: no

Apparoach:
1. I am using HashMap to clone the graph nodes and recursively processing every neighbor of the node
 */
public class CloneGraph {
    public HashMap<Node, Node>visited = new HashMap<>();

    public Node cloneGraph(Node node){
        if(node == null){
            return null;
        }

        if(visited.containsKey(node)){
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);

        for(Node nei: node.neighbors){
            cloneNode.neighbors.add(cloneGraph(nei));
        }
        return cloneNode;
    }
}
