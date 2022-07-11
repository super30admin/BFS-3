//Time-O(V+E)
//Space - O(V)
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
        if(node == null) return null;
        HashMap<Node, Node> clone = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node newNode = new Node(node.val);
        clone.put(node, newNode );
        while(!q.isEmpty()){
            Node cloned = q.poll();
            for(Node curr: cloned.neighbors){
                if(!clone.containsKey(curr)){
                    q.add(curr);
                    clone.put(curr, new Node(curr.val));
                    
                }
                clone.get(cloned).neighbors.add(clone.get(curr));
            }
        }
        return newNode;
    }
}