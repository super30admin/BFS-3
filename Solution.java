import java.util.*;

/*
// Definition for a Node.

}
*/

class Solution {

    //o(V + E) time and o(n) space
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
    HashMap<Node, Node> map ;
    public Node cloneGraph(Node node) {
        map= new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        if(node == null) return node;
        Node copyNode = clone(node);
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> children =  curr.neighbors;
            for(Node child: children){
                if(!map.containsKey(child)){
                                    Node copyChild = clone(child);

                    q.add(child);
                }
                //create edges of curr node
                //get deep copy of curr
                //add to that deep copy the deep copy of curr
                map.get(curr).neighbors.add(map.get(child));
            }
        }
        return map.get(node);
    }
    private Node clone(Node node){
        if(map.containsKey(node)) return map.get(node);
        Node copy = new Node(node.val);
        map.put(node, copy);
        return copy;
    }
}