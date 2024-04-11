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
    Map<Node, Node> map ;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        clone(node);

        while(!q.isEmpty()){
            Node curr = q.poll();

            //process its neighbors
            for(Node n : curr.neighbors){
                 if(!map.containsKey(n)){
                    clone(n);
                    q.add(n);
                }

                //add neighbors to deepcopy of curr
                map.get(curr).neighbors.add(map.get(n));

            }
        }

        return map.get(node);
    }

    private void clone(Node node){
        if(!map.containsKey(node)){
            map.put(node, new Node(node.val));
        }

        // return map.get(node);
    }
}