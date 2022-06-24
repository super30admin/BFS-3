import java.util.*;
public class CloneGraph {
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
         if(node == null) return null;
        
        //DFS
        
        map = new HashMap<>();
        dfs(node);
        
        return map.get(node);
    }
    
    private Node clone(Node node)
    {
        if(map.containsKey(node)) return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node,newNode);
        return newNode;
    }
    
    private void dfs(Node node){
        //base
        if(map.containsKey(node)) return;
        
        
        //logic
        clone(node);
        List<Node> neighbors = node.neighbors;
        for(Node n: neighbors)
        {
            //clone(n);
            dfs(n);
            map.get(node).neighbors.add(map.get(n));
            
        }
    }
}
