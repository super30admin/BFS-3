import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Time Complexity=O(V+E)
//Space Complexity=O(V)

public class CloneGraphDFS {
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
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        map=new HashMap<>();
        if(node==null) return  null;

        return dfs(node);

    }

    private Node dfs(Node node){
        //base
        if(map.containsKey(node)) return map.get(node);

        Node newNode=new Node(node.val);
        map.put(node,newNode);

        //logic
        List<Node> li=node.neighbors;
        for(Node curr:li){
            map.get(node).neighbors.add(dfs(curr));
        }
        return newNode;

    }
}
