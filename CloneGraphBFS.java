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
     //tc- o(V+E)
    //SC-O(V)
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node newNode = new Node(node.val);
        q.add(node);
        map.put(node,newNode);

        while(!q.isEmpty())
        {
           Node curr = q.poll();    
           List<Node> neighbors = curr.neighbors;
           for( Node n : neighbors)
           {
               if(!map.containsKey(n))
               {
                   Node deepcopy = new Node(n.val);
                   map.put(n,deepcopy);
                   q.add(n);
               }
             //get deepcopy of curr node i.e popped node
             //get the neighbours list of seepcopy node
             //add the deep copy ofthe neighbors
                   map.get(curr).neighbors.add(map.get(n));
               
           }
        }
        return newNode;
    }
}