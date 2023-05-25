import java.util.*;
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
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node deepNode = new Node(node.val);
        map.put(node,deepNode);
        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> nb = curr.neighbors;
            for(Node n:nb){
                if(!map.containsKey(n)){
                    Node deepCopy = new Node(n.val);
                    map.put(n,deepCopy);
                    q.add(n);
                }
                Node deepCurr = map.get(curr);
                deepCurr.neighbors.add(map.get(n));
            }
        }
        return deepNode;
    }
}
