
import java.util.*;

//Time: O(V + E)
//Space: O(V)

class cloneGr {
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        
        //hashmap to track if clone has been made already and if it has been visited already
        map = new HashMap<>();
        dfs(node);

        return map.get(node);
    }
    
    private void dfs(Node node){
        //base
        if(map.containsKey(node)) return;
        
        //logic
        map.put(node, new Node(node.val));
        
        for(Node neighbor: node.neighbors){
            dfs(neighbor);
            //add deep copy of neighbor to the deep copy of curr node
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }
}

