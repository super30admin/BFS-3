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

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Take a map to point the old Node to the new node, and a queue to bfs, create the new node if not present in the map, and set it the map, if present the, set its child to the old node child, if the child is not present in the map, then create the new Node and add it to the map and queue both.
// Your code here along with comments explaining your approach
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        if(node != null && node.neighbors.size() == 0) return new Node(node.val);
        HashMap<Node, Node> hm = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(!hm.containsKey(curr)){
               Node newNode = new Node(curr.val);
               hm.put(curr, newNode);
            }
            List<Node> neigh = curr.neighbors;
            if(neigh.size() > 0){
                for(Node ch : neigh){
                    if(!hm.containsKey(ch)){
                        q.add(ch);
                        Node newchNode = new Node(ch.val);
                        hm.put(ch, newchNode);
                    }
                    hm.get(curr).neighbors.add(hm.get(ch));
                }
            }
        }
        return hm.get(node);
    }
}
