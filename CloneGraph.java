//https://leetcode.com/problems/clone-graph
//TC: V+E
//SC: V+E
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
    Map<Node,Node> map;
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        cloneNode(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.neighbors == null) continue;
            for(Node neighbor : curr.neighbors){
                if(!map.containsKey(neighbor)){
                    cloneNode(neighbor);
                    q.add(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    private void cloneNode(Node node){
        if(!map.containsKey(node)){
            Node copyNode = new Node(node.val);
            map.put(node,copyNode);
        }
    }
}
