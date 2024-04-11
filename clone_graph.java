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
//TimeComplexity: O(V+E)
//SpaceComplexity:O(V)
class Solution {
    void cloneNode(HashMap<Node, Node> map, Node node) {
           if(map.containsKey(node)) return;
           Node newNode = new Node(node.val);
        map.put(node, newNode);
    }
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        cloneNode(map,node);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            for(Node children : current.neighbors) {
                 if(!map.containsKey(children)) {
                    cloneNode(map,children);
                    queue.add(children);
                 }
                 map.get(current).neighbors.add(map.get(children));
            }
        } 
     return map.get(node);
    }
}