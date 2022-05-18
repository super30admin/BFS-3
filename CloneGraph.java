// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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

    //BFS approach

    public Node cloneGraph(Node node) {

        if(node == null)
            return null;

        //to keep track of clones
        HashMap<Node, Node> map = new HashMap();
        //for running BFS
        Queue<Node> q = new LinkedList();

        //clone of given reference
        Node nodeClone = new Node(node.val);
        map.put(node, nodeClone);

        q.add(node);

        while(!q.isEmpty())
        {
            Node current = q.poll();
            //iterate over neighbors
            for(Node n : current.neighbors)
            {
                if(!map.containsKey(n))
                {
                    //make clone of neighbor, put in map and add to queue for processing
                    Node nClone = new Node(n.val);
                    map.put(n, nClone);
                    q.add(n);
                }
                //add neighbor's clone to list of current's clone
                map.get(current).neighbors.add(map.get(n));
            }
        }

        return nodeClone;
    }
}
