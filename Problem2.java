// Time: O(E)  // E>=val
// Space : O(V)

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
        if(node  == null){
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        // System.out.println(node.val);
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node,newNode);

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i = 0 ; i < cur.neighbors.size() ; i++){
                Node n = cur.neighbors.get(i);
                if(!map.containsKey(n)){
                    Node newNeighbor = new Node(n.val, new ArrayList<>());
                    map.put(n, newNeighbor);
                    q.add(n);

                }

                map.get(cur).neighbors.add(map.get(n));
            }
            

        }
        return newNode;

        
    }
}