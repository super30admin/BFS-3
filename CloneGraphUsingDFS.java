import java.util.HashMap;
import java.util.List;

// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes

public class CloneGraphUsingDFS {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null)return null;
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node){

        Node copyNode = clone(node);
        List<Node> neighbors = node.neighbors;
        if(neighbors!= null){
            for(Node neighbor : neighbors){
                if(!map.containsKey(neighbor)){
                    dfs(neighbor);
                }
                Node copyNeighbor = clone(neighbor);
                copyNode.neighbors.add(copyNeighbor);
            }
        }
    }

    private Node clone(Node node){
        if(!map.containsKey(node)){
            Node newNode = new Node(node.val);
            map.put(node, newNode);
        }
        return map.get(node);
    }
}
