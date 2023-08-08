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
    //Time complexity and Space Complexity both O(N) N is the number of nodes in the graph

    Map<Node, Node> map;//to maintain mapping between actial and clone
    public Node cloneGraphBFS(Node node) {
        if(node == null){
            return null;
        }
        map = new HashMap<>();
         Queue<Node> queue = new LinkedList<>();
         queue.offer(node);
         Node copyNode = clone(node);
         while(!queue.isEmpty()){
             Node current = queue.poll();
             for(Node child: current.neighbors){
                 if(!map.containsKey(child))queue.offer(child);
                 Node childClone = clone(child);

                 map.get(current).neighbors.add(childClone);
             }
         }

        return map.get(node);
    }

    public Node cloneGraphDFS(Node node) {
        if(node == null){
            return null;
        }
        map = new HashMap<>();
        helper(node);
        return map.get(node);

    }
    private void helper(Node node){
        //base
        if(map.containsKey(node))return;
        //logic
        clone(node);
        for(Node child: node.neighbors){
            helper(child);
            map.get(node).neighbors.add(map.get(child));
        }
    }

    private Node clone(Node node){

        if(!map.containsKey(node)){
            Node copyNode = new Node(node.val);
            map.put(node, copyNode);
        }
        return map.get(node);
    }
}
