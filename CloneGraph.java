/*
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
*/
// This uses a DFS approach along with a map to iterate through each node and iterate through the depth on each node.
// This will help iterate through all the nodes in depth and create a clone. We make sure to use map and not iterate through the node already created
class Solution {
    Node head;
    Map<Integer, Node> map = new HashMap();
    public Node cloneGraph(Node node) {
        clone(node);
        return map.get(1);
    }

    private void clone(Node node) {
        if(node==null) return;
        Node temp;
        temp = new Node();
        temp.val = node.val;
        map.put(temp.val, temp);

        List<Node> neighbors = new ArrayList();
        for(Node neighbor:node.neighbors) {
            if(map.containsKey(neighbor.val)) {
                neighbors.add(map.get(neighbor.val));
            } else {
                clone(neighbor);
                neighbors.add(map.get(neighbor.val));
            }
        }
        temp.neighbors = neighbors;
    }
}
