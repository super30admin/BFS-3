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
//Time Complexity = O(V+E);
//Space Complexity = O(V);
//Method: Maintain a HashMap with Nodes and it's copy Nodes references. So that we know if it's alread visited or for making the mappings. Iterate over the neighbors and as it's a graph, all are connected. We can clone it wholly.
class Solution {

    private HashMap<Node,Node> map;

    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        //base
        if(node == null)return null;
        //logic

        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            Node copycurr = clone(curr);
            for(Node ne: curr.neighbors){
                if(!map.containsKey(ne)){
                    q.add(ne);
                }
                Node copyNe = clone(ne);
                copycurr.neighbors.add(copyNe);
            }

        }
        return clone(node);
    }

    private Node clone(Node node){
        if(!map.containsKey(node)){
            map.put(node, new Node(node.val,new ArrayList<Node>()));
        }
        return map.get(node);
    }
}