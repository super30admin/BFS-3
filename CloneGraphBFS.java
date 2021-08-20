// Time Complexity : O(V + E)
// Space Complexity : O(V)

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
        if(node  == null)
            return node;
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        q.add(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Node n: cur.neighbors){
                if(!map.containsKey(n)){
                    Node newCur = new Node(n.val);
                    map.put(n, newCur);
                    q.add(n);
                }
                map.get(cur).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}