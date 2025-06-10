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


//Time: O(V+E) -
//Space: O(2V) -size of HashMap

class Solution {

    HashMap<Node,Node> map;
    Queue<Node> q;
    Node newNode;
    public Node cloneGraph(Node node) {

        this.map= new HashMap<>();
        this.q=new LinkedList<>();

        if(node==null) return null;

        q.add(node);

        while(!q.isEmpty()){

            Node curr=q.poll();
            Node newNode=cloneNode(curr);

            for(Node ne : curr.neighbors){

                if(!map.containsKey(ne)){
                    q.add(ne);
                }

                newNode.neighbors.add(cloneNode(ne));
            }
        }
        return map.get(node);
    }

    // func to clone the node and return the reference of new node
    private Node cloneNode(Node node){

        if(node==null) return null;

        if(map.containsKey(node)){
            return map.get(node);
        }

        map.put(node, new Node(node.val));

        return map.get(node);

    }
}