// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We use BFS traveral along with hash map to store the deep copy of Node
//We start by given node and create its deep copy and also get its neighbors and create its deep copy and using this create an edge

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
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        //create deep copy of initial node given
        Node newNode = new Node(node.val);
        //add that node with its deep copy to hash map
        map.put(node, newNode);
        q.add(node);

        while (!q.isEmpty()) {
            //get the initail node out
            Node cur = q.poll();
            //get its neighbors
            for (Node ne : cur.neighbors) {
                //check if deep copy of neighbors is already present in map if not create one
                if (!map.containsKey(ne)) {
                    Node newNeNode = new Node(ne.val);
                    //add this to map
                    map.put(ne, newNeNode);
                    //add the original neighbors to queue
                    q.add(ne);
                }
                //create an edge ie create deep copy of neighbors
                // curr node is 1 get its deep copy and to that add the deep copy neighbors
                map.get(cur).neighbors.add(map.get(ne));
            }
        }
        return map.get(node);

    }
}
