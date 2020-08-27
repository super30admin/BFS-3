//time:nodes+connections
//space:o(n)
//leetcode:Yes

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
        if(node == null)return node;
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node copyNode = new Node(node.val);
        q.add(node);
        map.put(node.val, copyNode);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node n : curr.neighbors){
                if(!map.containsKey(n.val)){
                    Node copy = new Node(n.val);
                    map.put(n.val, copy);
                    q.add(n);
                }
                //get copy of the original node
                //add to its neighbor, copy of my original node neigbor
                map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return copyNode; //map.get(node.val)
    }
}