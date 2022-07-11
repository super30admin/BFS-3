//https://leetcode.com/problems/clone-graph/
// Time Complexity :O(n)  
// Space Complexity :O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
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
        //null case
        if(node==null) return null;
        HashMap<Node,Node> map=new HashMap<>(); //original node to deep node
        Queue<Node> q=new LinkedList<>();
        Node newNode=new Node(node.val);
        q.add(node);
        map.put(node,newNode);
        while(!q.isEmpty())
        {
            Node curr=q.poll();
            List<Node> neighbors=curr.neighbors;
            for(Node n:neighbors)
            {
                if(!map.containsKey(n))
                {
                    q.add(n);
                    Node deepNode=new Node(n.val);
                    map.put(n,deepNode);
                }
                map.get(curr).neighbors.add(map.get(n));
            
            }
            
        }
        return newNode;
        
    }
}