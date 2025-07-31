// TC: O(V+E)
// SC: O(V)
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

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> bfs = new LinkedList<Node>();
        if(node == null) return null;

        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        bfs.add(node);

        while (!bfs.isEmpty()) {
            Node curr = bfs.poll();
            // check if clone is existing
            if (!map.containsKey(curr)) {
                map.put(curr, new Node(curr.val));
            }
            Node currClone = map.get(curr);

            // process neighbors
            for (Node ne : curr.neighbors) {
                if (!map.containsKey(ne)) {
                    map.put(ne, new Node(ne.val));
                    bfs.add(ne);
                }
                currClone.neighbors.add(map.get(ne));
            }
        }
        return cloneNode;
    }
}