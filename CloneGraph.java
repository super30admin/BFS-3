// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
import java.util.*;
public class CloneGraph {
    private static class Node {
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

    public static Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> que = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();
        Node clone = new Node(node.val);
        map.put(node, clone);
        que.offer(node);
        while(!que.isEmpty()) {
            Node temp = que.poll();
            for(Node n: temp.neighbors) {
                if(!map.containsKey(n)) {
                    Node c = new Node(n.val);
                    map.put(n, c);
                    que.offer(n);
                }
                map.get(temp).neighbors.add(map.get(n));
            }
        }
        return clone;
    }
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.neighbors.add(two);
        one.neighbors.add(four);

        two.neighbors.add(one);
        two.neighbors.add(three);

        three.neighbors.add(two);
        three.neighbors.add(four);

        four.neighbors.add(one);
        four.neighbors.add(three);

        Node clone = cloneGraph(one);

    }
}
