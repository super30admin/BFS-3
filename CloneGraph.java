//TC will be O(V+E)
//SC will be O(V)
//Using BFS


import java.util.*;

// Definition for a Node.
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



class CloneGraph {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {

        if (node == null){
            return null;
        }
        map = new HashMap<>();
        Node copyNode = clone(node);
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> neighbors = curr.neighbors;
            for(Node neighbor : neighbors){
                if(!map.containsKey(neighbor)){
                    Node clonedNode = clone(neighbor);
                    q.add(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return copyNode;
    }


    private Node clone(Node node){
        if(map.containsKey(node)){
            return map.get(node);
        }

        Node newnode = new Node(node.val);
        map.put(node, newnode);
        return newnode;
    }


    public static void main(String[] args) {
        // Create nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Set neighbors for each node
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        CloneGraph obj = new CloneGraph();
        obj.cloneGraph(node1);
    }


}