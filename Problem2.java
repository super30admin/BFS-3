/*
Clone Graph
approach: once you create a node, put in map
for both
time: O(V+E)
space: O(V)
 */
public class Problem2 {
    /*
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        map = new HashMap<>();
        return helper(node);
    }

    private Node helper(Node node) {
        if(map.containsKey(node)) return map.get(node);
        Node head = new Node(node.val);
        map.put(node, head);
        for(Node n: node.neighbors) {
            head.neighbors.add(helper(n));
        }
        return head;
    }

     */
}
