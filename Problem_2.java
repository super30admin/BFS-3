// Time complexity - O(V+E)
// Space complexity - O(n)

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
        if(node == null) return node;
        Map<Integer,Node> map = new HashMap<>();
        Queue<Node> q= new LinkedList<>();
        q.add(node);
        Node nodeCopy = new Node(node.val);
        map.put(node.val, nodeCopy);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node n : curr.neighbors){
                if(!map.containsKey(n.val)){
                    Node c = new Node(n.val);
                    map.put(n.val,c);
                    q.add(n);
                }
                
                map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return nodeCopy;
    }
}
