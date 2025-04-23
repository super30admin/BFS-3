import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//TC-O(v*e) SC-O(v)
public class CloneGraph {
    HashMap<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node== null) return null;
         dfs(node,map);
         return map.get(node);
    }
    public void dfs(Node node,HashMap<Node,Node> map)
    {
        if(map.containsKey(node))
            return;
        Node newnode= new Node(node.val);
        map.put(node,newnode);

        for(Node ne: node.neighbors)
        {
            dfs(ne,map);
            map.get(node).neighbors.add(map.get(ne));
        }


    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            this.neighbors = new ArrayList<Node>();
        }
        public Node(int value) {
            val = value;
            this.neighbors = new ArrayList<Node>();
        }
        public Node(int value, ArrayList<Node> neighbors) {
            val = value;
            this.neighbors = neighbors;
        }
    }
}
/* BFS

public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node,Node> map=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        Node newNode=new Node(node.val);
        map.put(node,newNode);
        q.add(node);
        while(!q.isEmpty()){
            Node curr=q.poll();
            List<Node> neighbors=curr.neighbors;
            for(Node ne:neighbors){
                if(!map.containsKey(ne)){
                    Node copyNode=new Node(ne.val);
                    map.put(ne,copyNode);
                    q.add(ne);
                }
                map.get(curr).neighbors.add(map.get(ne));
            }
        }
        return newNode;
    }
*/