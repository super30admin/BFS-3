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

/*
    Queue -> Original Node
    HashMap -> Node_Val, Clone Node
    Time: O(N)
    Space: O(N)
*/
class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null)
            return null;
        
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Node> hm = new HashMap<>();
        
        queue.offer(node);
        Node cloneNode = new Node(node.val, new ArrayList<>());
        hm.put(node.val, cloneNode);
        
        
        while(!queue.isEmpty())
        {
            Node current = queue.poll(); 
            for(Node temp : current.neighbors)
            {
                if(!hm.containsKey(temp.val))
                {
                    queue.offer(temp);
                    Node newcloneNode = new Node(temp.val, new ArrayList<>());
                    hm.put(temp.val, newcloneNode);
                }
                hm.get(current.val).neighbors.add(hm.get(temp.val));
            }
        } 
        
        return cloneNode;
    }
}

