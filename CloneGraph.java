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
    HashMap<Node, Node> hm = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        //Initialize the start node with node value and add node to queue
        Node curr = new Node(node.val);
        hm.put(node, curr);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        //Iterate over all the elements of the queue
        while(!q.isEmpty()){
            curr = q.poll();
            //poll the element, get the list of neighbors
            List<Node> cn = hm.get(curr).neighbors;
            List<Node> n = curr.neighbors;
            for(int i=0;i<n.size();i++){
                //if the neighboring node is already created then just add to neighbors list
                if(hm.containsKey(n.get(i))){
                    cn.add(hm.get(n.get(i)));
                }
                //else create a new node, add it to neighbors list and also to the queue and hashmap
                else{
                    Node k = new Node(n.get(i).val);
                    hm.put(n.get(i), k);
                    q.add(n.get(i));
                    cn.add(k);
                }
            }
        }
        //return the cloned copy of start node
        return hm.get(node);
    }
}

//Time complexity : O(E+V) where V is the number of vertices
//Space complexity : (V) where v is the number of elements in the hashmap
