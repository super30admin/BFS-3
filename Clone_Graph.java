//Time Complexity: o(n), vertices
//space complexity: o(n)

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
        
        HashMap<Node, Node> map = new HashMap<>();
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node copy = new Node(node.val);
        map.put(node,copy);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> neighbors = curr.neighbors;
            for(Node n :neighbors )
            {
                if(!map.containsKey(n)){
                    map.put(n,new Node(n.val));
                    q.add(n);
                }
                
                 map.get(curr).neighbors.add(map.get(n));
            }    
        }
        
        
        return map.get(node);
    }
}
