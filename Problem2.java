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
//TC: O(v+e)
//SC: O(v+e)
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        q.add(node);

        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node ne : curr.neighbors){
                if(!map.containsKey(ne)){
                    Node copy = new Node(ne.val);
                    map.put(ne, copy);
                    q.add(ne);
                }
                map.get(curr).neighbors.add(map.get(ne));
            }
        }
        return copyNode;
    }

}
