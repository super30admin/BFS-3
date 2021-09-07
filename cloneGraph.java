
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
        if(node==null)
            return null;
        HashMap<Node,Node> map=new HashMap<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(node);
        map.put(node,new Node(node.val));
        
        while(!queue.isEmpty()){
            Node oldNode=queue.poll();
            Node newNode=map.get(oldNode);
            
            for(Node neigh:oldNode.neighbors){
                if(!map.containsKey(neigh)){
                    map.put(neigh,new Node(neigh.val));
                    queue.add(neigh);
                }
                newNode.neighbors.add(map.get(neigh));
            }
        }
        
        return map.get(node);
    }
}