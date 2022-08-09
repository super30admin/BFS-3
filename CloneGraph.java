// Time O(n)
// Space O(n) where n is the number of nodes in the graph (V+E)
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
        if(node==null) return node;
        Node newNode = new Node(node.val);
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();
        map.put(node,newNode);
        q.add(node);
        while(!q.isEmpty())
        {
            Node curr= q.poll();
             Node currCopy ;
            if(!map.containsKey(curr))
            {
               currCopy= new Node(curr.val);
               map.put(curr,currCopy); 
            }
            else
                currCopy= map.get(curr);
            for(Node n : curr.neighbors)
            {   Node neighborCopy = map.getOrDefault(n, new Node(n.val));
                if(!map.containsKey(n)) q.add(n);
                currCopy.neighbors.add( neighborCopy );
                map.put(n,neighborCopy);
            }
                
        }
        return newNode;
        
    }
}