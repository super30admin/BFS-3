// Time Complexity : O(V+E)
// Space Complexity :O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



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


class CloneGraph {
    public static void main(String argsp[]) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        node1.neighbors.add(node2);
        node.neighbors.add(node1);
        node.neighbors.add(node3);
        System.out.println(cloneGraph(node).val);
        
    }
    public static Node cloneGraph(Node node) {
        HashMap<Node,Node> map = new HashMap<>();
        if(node == null) return null;
        Node newNode = new Node(node.val);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node,newNode);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            for(Node child: curr.neighbors) {
                if(!map.containsKey(child)) {
                    Node copyChild = new Node(child.val);
                    map.put(child,copyChild);
                    q.add(child);
                }
                map.get(curr).neighbors.add(map.get(child));
            }
        }
        return map.get(node);
    }
}