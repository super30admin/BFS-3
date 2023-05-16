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
// TC-O(V+E),SC-O(N)
//create copy of given node, add to queue for bfs and to hashmap of orig and copy of the node.Do bfs and for each node, for each of its neighbours, create copy if not already present and add it to neighbours of its copy.
class Solution {
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        this.map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node newhead = new Node(node.val);
        map.put(node,newhead);
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node child:curr.neighbors){
                if(!map.containsKey(child)){
                    Node newchild = new Node(child.val);
                    q.add(child); map.put(child,newchild);
                }
                map.get(curr).neighbors.add(map.get(child));
            }

        }

        return map.get(node);

        
    }
}