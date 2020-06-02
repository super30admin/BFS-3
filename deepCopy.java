
// Time Complexity : O(V+E)
// Space Complexity :O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

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
        Queue<Node> q = new LinkedList<>();
        Node copyNode = new Node(node.val);
        HashMap<Node,Node> map = new HashMap<>();
        map.put(node,copyNode);
        q.add(node);
        while(!q.isEmpty())
        {
            Node polledNode = q.poll();
            copyNode = map.get(polledNode);
            for(Node neighbour:polledNode.neighbors)
            {
                if(!map.containsKey(neighbour))
                {
                    Node newNode = new Node(neighbour.val);
                    map.put(neighbour,newNode);
                    q.add(neighbour);
                }
          
                copyNode.neighbors.add(map.get(neighbour));
            }
        }
        return map.get(node);
    }
}