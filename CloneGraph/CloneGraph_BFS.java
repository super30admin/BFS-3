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

/* Time Complexity : O(V+E) */
/* Space Complexity : O(V)
 * 	size of the hashmap  */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//BFS

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        //map to maintain link b/n original node and copy of that node
        HashMap<Node, Node> map = new HashMap<>();
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        //queue to iterate over the graph and add the neighbors to the copy's of nodes
        Queue<Node> q = new  LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node currNode = q.poll();
            for(Node child: currNode.neighbors){
                if(!map.containsKey(child)){
                    Node copyChild = new Node(child.val);
                    map.put(child, copyChild);
                    q.add(child);
                }
                map.get(currNode).neighbors.add(map.get(child));
            }
        }
        return copyNode;
    }
}