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

class cloneGraphBFS {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        map = new HashMap();
        Queue<Node> q = new LinkedList();
        Node copyNode = clone(node);
        q.add(node);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> neighbor = curr.neighbors;
            for(Node n : neighbor){
                if(!map.containsKey(n)){
                    clone(n);
                    q.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return copyNode;
    }
    
    private Node clone(Node node){
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        return copyNode;
    }
}

//time complexity O(V + E)
//space complexity O(V) where V stands for vertics and E stands for edges