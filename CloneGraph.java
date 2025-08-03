// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : maintain hashmap mapping node in original graph to node in cloned graph. Traverse through the graph using BFS(or DFS)
/// for each node, check if cloned node exists if not create and add to map. Then create the edges between cloned graph's nodes as in original graph

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
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        if(node==null){
            return null;
        }
        Node copyHead = new Node(node.val);
        map.put(node, copyHead);
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.println(curr.val);
            for(Node ne:curr.neighbors){
                if(!map.containsKey(ne)){
                    Node newNode = new Node(ne.val);
                    map.put(ne, newNode);
                    q.add(ne);
                }
                Node copyCurr = map.get(curr);
                copyCurr.neighbors.add(map.get(ne));
            }
        }
        return copyHead;
    }
}